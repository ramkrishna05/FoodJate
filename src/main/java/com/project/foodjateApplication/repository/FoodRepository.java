package com.project.foodjateApplication.repository;

import com.project.foodjateApplication.models.FoodIteam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodIteam ,Integer> {
}
