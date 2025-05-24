package com.codedifferently.inventory.item.repo;

import com.codedifferently.inventory.core.exception.ResourceCreationException;
import com.codedifferently.inventory.core.exception.ResourceNotFoundException;
import com.codedifferently.inventory.item.model.InventoryItem;
import com.codedifferently.inventory.item.services.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public InventoryItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public InventoryItem create(InventoryItem item) throws ResourceCreationException {
        Optional<InventoryItem> optional = itemRepository.findByName(item.getName());
        if (optional.isPresent()) {
            throw new ResourceCreationException("Item with name already exists: " + item.getName());
        }
        return itemRepository.save(item);
    }

    @Override
    public InventoryItem getById(Long id) throws ResourceNotFoundException {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No InventoryItem found with ID: " + id));
    }

    @Override
    public InventoryItem getByName(String name) throws ResourceNotFoundException {
        return itemRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("No InventoryItem found with name: " + name));
    }

    @Override
    public List<InventoryItem> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public InventoryItem update(Long id, InventoryItem itemDetails) throws ResourceNotFoundException {
        InventoryItem item = getById(id);
        item.setName(itemDetails.getName());
        item.setQuantity(itemDetails.getQuantity());
        item.setLocation(itemDetails.getLocation());
        item.setLockerCombo(itemDetails.getLockerCombo());
        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        InventoryItem item = getById(id);
        itemRepository.delete(item);
    }
}
