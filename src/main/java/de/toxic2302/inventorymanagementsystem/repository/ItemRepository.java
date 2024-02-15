package de.toxic2302.inventorymanagementsystem.repository;

import de.toxic2302.inventorymanagementsystem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
