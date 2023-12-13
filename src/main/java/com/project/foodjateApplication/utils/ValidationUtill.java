package com.project.foodjateApplication.utils;

import com.project.foodjateApplication.models.Restaurant;
import com.project.foodjateApplication.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationUtill {
   final  RestaurantRepository restaurantRepository;


    @Autowired

    public ValidationUtill(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public  boolean  restaurantValidation(int id)
    {
        Optional<Restaurant>restaurantOptional=restaurantRepository.findById(id);
        return restaurantOptional.isPresent();
    }
}
