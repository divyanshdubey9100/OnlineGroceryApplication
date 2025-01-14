package com.onlinegroceryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegroceryapplication.model.GroceryItem;


public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{

}
