package de.toxic2302.inventorymanagementsystem.core.modules.item.repository;

import de.toxic2302.inventorymanagementsystem.core.modules.item.entity.Item;
import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    //List<Item> findAllByUserId(UUID user_id);
    /*List<Item> findAllByUserId(Long userId);*/
    List<Item> findAllByUser(User user);
}
