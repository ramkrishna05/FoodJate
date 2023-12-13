package com.project.foodjateApplication.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartStatusResponse {
    String  name;
    String contactNumber;
    String address;
    double carttotal;
    List<FoodResponse> foodItems;
    String restuarantname;
}
