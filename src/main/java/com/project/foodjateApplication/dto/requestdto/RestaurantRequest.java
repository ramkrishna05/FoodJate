package com.project.foodjateApplication.dto.requestdto;

import com.project.foodjateApplication.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    String name;
    String location;
    RestaurantCategory restaurantCategory;
    String contactNumber;


}
