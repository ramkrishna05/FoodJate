package com.project.foodjateApplication.dto.responsedto;

import com.project.foodjateApplication.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FoodResponse {
    String dishname;
    double price;
    FoodCategory foodCategory;
    boolean veg;
    int quantityadded;
}
