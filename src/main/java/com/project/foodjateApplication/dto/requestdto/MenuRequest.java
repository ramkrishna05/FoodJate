package com.project.foodjateApplication.dto.requestdto;

import com.project.foodjateApplication.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequest
{
    int restaurantId;

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    boolean available;
}

