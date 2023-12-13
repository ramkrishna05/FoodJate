package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.responsedto.FoodResponse;
import com.project.foodjateApplication.dto.responsedto.OrderResponse;
import com.project.foodjateApplication.models.Cart;
import com.project.foodjateApplication.models.FoodIteam;
import com.project.foodjateApplication.models.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OrderTransformer {
    public static  OrderEntity prepaiaredOrder(Cart cart)
    {
        return OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .orderTotal(cart.getCartTotal())
                .build();
    }
    public static OrderResponse OrderToOrderResponse(OrderEntity order)
    {
        List<FoodResponse>foodResponses=new ArrayList<>();
        for (FoodIteam foodIteam:order.getFoodIteamList())
        {
          FoodResponse f=  FoodResponse.builder()
                    .foodCategory(foodIteam.getMenuIteam().getFoodCategory())
                    .price(foodIteam.getMenuIteam().getPrice())
                    .dishname(foodIteam.getMenuIteam().getDishName())
                    .veg(foodIteam.getMenuIteam().isVeg())
                    .quantityadded(foodIteam.getRequiredQuantity())
                    .build();
            foodResponses.add(f);
        }


      return   OrderResponse.builder()
                .orderId(order.getOrderId())
                .orderTotal(order.getOrderTotal())
                .customberName(order.getCustomber().getName())
                .customberMobile(order.getCustomber().getContactNumber())
                .deliveryPartnerMobile(order.getDeliveryPartner().getContactNumber())
                .deliveryPartnerName(order.getDeliveryPartner().getName())
                .restaurantName(order.getRestaurant().getName())
                .foodResponseList(foodResponses)
                .build();
    }
}
