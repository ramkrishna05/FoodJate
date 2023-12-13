package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.requestdto.MenuRequest;
import com.project.foodjateApplication.models.MenuIteam;

public class FoodTransformer {
    public static MenuIteam  foodRequestTOFoodIteam(MenuRequest menuRequest)
    {
        return MenuIteam.builder()
                .foodCategory(menuRequest.getCategory())
                .price(menuRequest.getPrice())
                .veg(menuRequest.isVeg())
                .available(menuRequest.isAvailable())
                .dishName(menuRequest.getDishName())
                .build();
    }
}
