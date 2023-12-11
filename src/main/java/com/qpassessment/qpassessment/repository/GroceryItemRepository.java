package com.qpassessment.qpassessment.repository;

import com.qpassessment.qpassessment.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    List<GroceryItem> findByQuantityNot(int quantity);
}
