package com.project.foodjateApplication.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    double carttotal;
    List<MenuResponse>foodItems;

}
