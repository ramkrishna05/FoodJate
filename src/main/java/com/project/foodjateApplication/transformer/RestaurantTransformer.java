package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.requestdto.RestaurantRequest;
import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.dto.responsedto.RestaurantResponse;
import com.project.foodjateApplication.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {
    public static Restaurant restaurantRequestToRestaurant(RestaurantRequest restaurantRequest)
    {
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .location(restaurantRequest.getLocation())
                .contactNumber(restaurantRequest.getContactNumber())
                .opend(true)
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .menuIteamList(new ArrayList<>())
                .orderEntityList(new ArrayList<>())
                .build();
    }
    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant)
    {
        List<MenuResponse>menuResponseList= restaurant.getMenuIteamList().stream().map(fooditeam->MenuTransformer.menuIteamtoMenuResponse(fooditeam)).collect(Collectors.toList());
         return RestaurantResponse.builder()
                 .menuResponseList(menuResponseList)
                 .open(restaurant.isOpend())
                 .contactNumber(restaurant.getContactNumber())
                 .location(restaurant.getLocation())
                 .name(restaurant.getName())

                 .build();


    }
}
