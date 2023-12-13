package com.project.foodjateApplication.repository;

import com.project.foodjateApplication.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
