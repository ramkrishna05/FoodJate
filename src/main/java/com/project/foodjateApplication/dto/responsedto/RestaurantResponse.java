package com.project.foodjateApplication.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    String name;
    String location;
    String contactNumber;
    boolean open;
    List<MenuResponse>menuResponseList;
}
