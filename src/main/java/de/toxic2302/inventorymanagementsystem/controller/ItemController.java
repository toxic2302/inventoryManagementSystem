package de.toxic2302.inventorymanagementsystem.controller;

import de.toxic2302.inventorymanagementsystem.model.Item;
import de.toxic2302.inventorymanagementsystem.repository.ItemRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(ItemController.class);
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    Collection<Item> items() {
        return itemRepository.findAll();
    }

    @GetMapping("/item/{id}")
    ResponseEntity<?> getItem(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/item")
    ResponseEntity<Item> createItem(@Valid @RequestBody Item item) throws URISyntaxException {
        log.info("Request to create item: {}", item);
        Item result = itemRepository.save(item);
        return ResponseEntity.created(new URI("/api/item/" + result.getId())).body(result);
    }

    @PutMapping("/item/{id}")
    ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
        log.info("Request to update item: {}", item);
        Item result = itemRepository.save(item);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        log.info("Request to delete item: {}", id);
        itemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
