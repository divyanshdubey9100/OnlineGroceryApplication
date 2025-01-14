package com.com.onlinegroceryapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.onlinegroceryapplication.model.GroceryItem;
import com.onlinegroceryapplication.service.GroceryItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groceries")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    // User - View all items
    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryItemService.getAllItems();
    }

    // Admin - Add a new grocery item
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public GroceryItem addItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.addNewItem(groceryItem);
    }

    // Admin - Update a grocery item
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem updatedItem) {
        return groceryItemService.updateItem(id, updatedItem);
    }

    // Admin - Remove a grocery item
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable Long id) {
        return groceryItemService.deleteItem(id);
    }

    // Admin - Update inventory level
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/{id}/inventory")
    public void updateInventory(@PathVariable Long id, @RequestParam Integer quantity) {
        groceryItemService.updateInventory(id, quantity);
    }

    // User - View a single grocery item
    @GetMapping("/{id}")
    public Optional<GroceryItem> getItemById(@PathVariable Long id) {
        return groceryItemService.getItemById(id);
    }
}