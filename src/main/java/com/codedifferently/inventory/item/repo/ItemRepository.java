package com.codedifferently.inventory.item.repo;

import com.codedifferently.inventory.item.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ItemRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByName(String name);
}
