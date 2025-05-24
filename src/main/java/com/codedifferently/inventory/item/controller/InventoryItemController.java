package com.codedifferently.inventory.item.controller;

import com.codedifferently.inventory.item.model.InventoryItem;
import com.codedifferently.inventory.item.services.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAll() {
        List<InventoryItem> items = inventoryItemService.getAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem item) {
        item = inventoryItemService.create(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<InventoryItem> getById(@PathVariable("id") Long id) {
        InventoryItem item = inventoryItemService.getById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<InventoryItem> getByName(@RequestParam String name) {
        InventoryItem item = inventoryItemService.getByName(name);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<InventoryItem> update(@PathVariable("id") Long id, @RequestBody InventoryItem itemDetail) {
        itemDetail = inventoryItemService.update(id, itemDetail);
        return new ResponseEntity<>(itemDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        inventoryItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}