package com.codedifferently.inventory.item.services;

import com.codedifferently.inventory.core.exception.ResourceCreationException;
import com.codedifferently.inventory.core.exception.ResourceNotFoundException;
import com.codedifferently.inventory.item.model.InventoryItem;

import java.util.List;

public interface InventoryItemService {
    InventoryItem create(InventoryItem item) throws ResourceCreationException;
    InventoryItem getById(Long id) throws ResourceNotFoundException;
    InventoryItem getByName(String name) throws ResourceNotFoundException;
    List<InventoryItem> getAll();
    InventoryItem update(Long id, InventoryItem itemDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
