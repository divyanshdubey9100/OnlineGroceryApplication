package com.onlinegroceryapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegroceryapplication.model.GroceryItem;
import com.onlinegroceryapplication.repository.GroceryItemRepository;



@Service
public class GroceryItemService {
	
@Autowired
private GroceryItemRepository groceryItemRepository;

public List<GroceryItem> getAllItems() {
    return groceryItemRepository.findAll();
}

public Optional<GroceryItem> getItemById(Long id) {
    return groceryItemRepository.findById(id);
}

public GroceryItem addNewItem(GroceryItem groceryItem) {
    return groceryItemRepository.save(groceryItem);
}

public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
    Optional<GroceryItem> existingItem = groceryItemRepository.findById(id);
    if (existingItem.isPresent()) {
        GroceryItem item = existingItem.get();
        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setInventory(updatedItem.getInventory());
        return groceryItemRepository.save(item);
    }
    return null;
}

public boolean deleteItem(Long id) {
    if (groceryItemRepository.existsById(id)) {
        groceryItemRepository.deleteById(id);
        return true;
    }
    return false;
}

public void updateInventory(Long id, Integer quantity) {
    Optional<GroceryItem> item = groceryItemRepository.findById(id);
    item.ifPresent(groceryItem -> {
        groceryItem.setInventory(groceryItem.getInventory() - quantity);
        groceryItemRepository.save(groceryItem);
    });
}
}
