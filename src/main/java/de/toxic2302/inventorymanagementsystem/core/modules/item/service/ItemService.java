package de.toxic2302.inventorymanagementsystem.core.modules.item.service;

import de.toxic2302.inventorymanagementsystem.core.modules.item.dto.ItemDto;
import de.toxic2302.inventorymanagementsystem.core.modules.item.entity.Item;
import de.toxic2302.inventorymanagementsystem.core.modules.item.mapper.ItemMapper;
import de.toxic2302.inventorymanagementsystem.core.modules.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    // ---- Globales ----
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    // ---- Constructor ----
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    // ---- Functions ----
    public Collection<ItemDto> getAllItems() {
        return itemMapper.toDtoCollection(itemRepository.findAll());
    }

    public Collection<ItemDto> getAllItemsByUser(String userid) {
        return itemMapper.toDtoCollection(itemRepository.findAllByUserId(UUID.fromString(userid)));
    }

    public Optional<ItemDto> getItemById(UUID itemId) {
        return Optional.ofNullable(itemMapper.toDto(itemRepository.findById(itemId)));
    }

    public ItemDto saveItem(ItemDto itemDto) {
        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(itemDto)));
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
