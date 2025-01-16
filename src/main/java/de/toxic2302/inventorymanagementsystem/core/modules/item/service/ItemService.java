package de.toxic2302.inventorymanagementsystem.core.modules.item.service;

import de.toxic2302.inventorymanagementsystem.core.modules.item.dto.ItemDto;
import de.toxic2302.inventorymanagementsystem.core.modules.item.entity.Item;
import de.toxic2302.inventorymanagementsystem.core.modules.item.mapper.ItemMapper;
import de.toxic2302.inventorymanagementsystem.core.modules.item.repository.ItemRepository;
import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import de.toxic2302.inventorymanagementsystem.core.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    // ---- Globales ----
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;

    // ---- Constructor ----
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService = userService;
    }

    // ---- Functions ----
    public Collection<ItemDto> getAllItems(User user) {
        return itemMapper.toDtoCollection(itemRepository.findAllByUser(user));
    }

    /*public Collection<ItemDto> getAllItemsByUser(String userid) {
        return itemMapper.toDtoCollection(itemRepository.findAllByUserId(Long.valueOf(userid)));
    }*/

    public Optional<ItemDto> getItemById(UUID itemId) {
        //TODO 26.11.24 floriankolb: eventuell anders machen
        final Optional<Item> itemById = itemRepository.findById(itemId);
        return Optional.ofNullable(itemMapper.toDto(itemById));
    }

    public ItemDto saveItem(ItemDto itemDto) {
        final Item item = itemMapper.toEntity(itemDto);
        item.setUser(userService.getCurrentUser());
        return itemMapper.toDto(itemRepository.save(item));
    }

    public ItemDto updateItem(ItemDto itemDto, UUID id) {
        final Optional<Item> existingItem = itemRepository.findById(id);

        existingItem.ifPresent(item -> {
            itemMapper.partialUpdate(item, itemDto);
        });

        itemRepository.save(existingItem.get());

        return itemMapper.toDto(existingItem.get());
    }

    public void deleteItemById(UUID itemId) {
        itemRepository.deleteById(itemId);
    }
}
