package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.models.MenuIteam;

public class MenuTransformer {
    public static MenuResponse menuIteamtoMenuResponse(MenuIteam menuIteam)
    {
        return MenuResponse.builder()
                .dishname(menuIteam.getDishName())
                .veg(menuIteam.isVeg())
                .price(menuIteam.getPrice())
                .foodCategory(menuIteam.getFoodCategory())
                .build();
    }
}
