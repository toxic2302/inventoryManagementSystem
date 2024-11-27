package de.toxic2302.inventorymanagementsystem.core.modules.item.controller;

import de.toxic2302.inventorymanagementsystem.core.modules.item.dto.ItemDto;
import de.toxic2302.inventorymanagementsystem.core.modules.item.service.ItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ItemController {

    // ---- Globales ----
    private final Logger log = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    // ---- Constructor ----
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // ---- Functions ----
    @GetMapping("/items")
    Collection<ItemDto> items() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{userId}")
    Collection<ItemDto> itemsByUserId(@PathVariable String userId) {
        return itemService.getAllItemsByUser(userId);
    }

    @GetMapping("/item/{id}")
    ResponseEntity<?> getItem(@PathVariable UUID id) {
        final Optional<ItemDto> itemById = itemService.getItemById(id);
        return itemById.isPresent() ? ResponseEntity.ok().body(itemById.get()) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/item")
    ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto item, @AuthenticationPrincipal OAuth2User user) throws URISyntaxException {
        log.info("Request to create item: {}", item);

        final ItemDto itemDto = itemService.saveItem(item);
        return ResponseEntity.created(new URI("/api/item/" + itemDto.getId())).body(itemDto);
    }

    @PostMapping("/item/{id}")
    ResponseEntity<ItemDto> updateItem(@Valid @RequestBody ItemDto item, @PathVariable UUID id) {
        log.info("Request to update item: {}", item);

        return ResponseEntity.ok().body(itemService.updateItem(item, id));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable UUID id) {
        log.info("Request to delete item: {}", id);

        itemService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }
}
