package com.project.foodjateApplication.repository;

import com.project.foodjateApplication.Enum.FoodCategory;
import com.project.foodjateApplication.models.MenuIteam;
import com.project.foodjateApplication.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuIteamRepository extends JpaRepository<MenuIteam,Integer> {
    List<MenuIteam> findByFoodCategory(FoodCategory foodCategory);
    List<MenuIteam> findByVeg(boolean isveg);
    List<MenuIteam>findTop5ByRestaurantOrderByPriceAsc(Restaurant restaurant);
}
