package com.project.foodjateApplication.service;

import com.project.foodjateApplication.dto.requestdto.MenuRequest;
import com.project.foodjateApplication.dto.requestdto.RestaurantRequest;
import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.dto.responsedto.RestaurantResponse;
import com.project.foodjateApplication.exceptions.RestaurantNotFoundExceptions;
import com.project.foodjateApplication.models.MenuIteam;
import com.project.foodjateApplication.models.Restaurant;
import com.project.foodjateApplication.repository.RestaurantRepository;
import com.project.foodjateApplication.transformer.FoodTransformer;
import com.project.foodjateApplication.transformer.RestaurantTransformer;
import com.project.foodjateApplication.utils.ValidationUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;
    final ValidationUtill validationUtill;

@Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ValidationUtill validationUtill) {
        this.restaurantRepository = restaurantRepository;
    this.validationUtill = validationUtill;
}

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest)
    {
        Restaurant restaurant= RestaurantTransformer.restaurantRequestToRestaurant(restaurantRequest);
        Restaurant restaurant1=restaurantRepository.save(restaurant);
        return RestaurantTransformer.RestaurantToRestaurantResponse(restaurant);
    }

    public String changeHotelStatus(int id)
    {
        Optional<Restaurant>optionalRestaurant=restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty())
        {
            throw new RestaurantNotFoundExceptions("restaurant not found");

        }
        Restaurant restaurant=optionalRestaurant.get();
        if(restaurant.isOpend())
        {
            restaurant.setOpend(!restaurant.isOpend());
            restaurantRepository.save(restaurant);
            return "restaurant is close now";
        }
        else
        {
            restaurant.setOpend(!restaurant.isOpend());
            restaurantRepository.save(restaurant);
            return "restaurant is open now";
        }
    }
    public RestaurantResponse addMenuIteam(MenuRequest menuRequest)
    {
        int id=menuRequest.getRestaurantId();
        if(!validationUtill.restaurantValidation(id))
        {
            throw new RestaurantNotFoundExceptions("restauran not ragister..please registere your restaurant ");
        }
        Restaurant restaurant=restaurantRepository.findById(id).get();
        MenuIteam menuIteam= FoodTransformer.foodRequestTOFoodIteam(menuRequest);
        menuIteam.setRestaurant(restaurant);
        restaurant.getMenuIteamList().add(menuIteam);
        Restaurant restaurant1=restaurantRepository.save(restaurant);
        return RestaurantTransformer.RestaurantToRestaurantResponse(restaurant1);



    }
    public List<MenuResponse> getRestaurantMenu(int id)
    {
        if(!validationUtill.restaurantValidation(id))
            throw new RestaurantNotFoundExceptions("Restaurant not avaliable ..please check reataurant name");
        Restaurant restaurant=restaurantRepository.findById(id).get();
        RestaurantResponse restaurantResponse=RestaurantTransformer.RestaurantToRestaurantResponse(restaurant);
        return restaurantResponse.getMenuResponseList();
    }
    public List<MenuResponse> getMenuBelowPrice(int id ,double price)
    {
        if(!validationUtill.restaurantValidation(id))
            throw new RestaurantNotFoundExceptions("restaurant not found ..please enter the correct Restaurant name ");
        Restaurant restaurant=restaurantRepository.findById(id).get();
        RestaurantResponse restaurantResponse=RestaurantTransformer.RestaurantToRestaurantResponse(restaurant);
     return    restaurantResponse.getMenuResponseList().stream().filter(fooditeam -> fooditeam.getPrice()<price).collect(Collectors.toList());

    }

}
