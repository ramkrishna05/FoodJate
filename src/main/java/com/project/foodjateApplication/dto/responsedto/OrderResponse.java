package com.project.foodjateApplication.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    String orderId;
    double orderTotal;
    String customberName;
    String  customberMobile;
    String deliveryPartnerName;
    String deliveryPartnerMobile;
    String restaurantName;
    List<FoodResponse>foodResponseList;
}
