package com.project.foodjateApplication.service;

import com.project.foodjateApplication.Enum.FoodCategory;
import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.exceptions.RestaurantNotFoundExceptions;
import com.project.foodjateApplication.models.MenuIteam;
import com.project.foodjateApplication.models.Restaurant;
import com.project.foodjateApplication.repository.MenuIteamRepository;
import com.project.foodjateApplication.repository.MenuIteamRepository;
import com.project.foodjateApplication.repository.RestaurantRepository;
import com.project.foodjateApplication.transformer.MenuTransformer;
import com.project.foodjateApplication.utils.ValidationUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    final MenuIteamRepository menuIteamRepository;
    final ValidationUtill validationUtill;
    final RestaurantRepository restaurantRepository;

@Autowired
    public FoodService( MenuIteamRepository menuIteamRepository, ValidationUtill validationUtill, RestaurantRepository restaurantRepository) {
    this.menuIteamRepository = menuIteamRepository;
 //   this.foodRepository = foodRepository;
    this.validationUtill = validationUtill;
    this.restaurantRepository = restaurantRepository;
}
    public List<MenuResponse> getFoodCategoryWise(FoodCategory foodCategory)
    {
        List<MenuIteam>menuIteamList=menuIteamRepository.findByFoodCategory(foodCategory);
        return menuIteamList.stream().map(fooditeam -> MenuTransformer.menuIteamtoMenuResponse(fooditeam)).collect(Collectors.toList());
    }
    public  List<MenuResponse> getAllVegFood()
    {
        List<MenuIteam>menuIteamList=menuIteamRepository.findByVeg(true);
        return menuIteamList.stream().map(fooditeam -> MenuTransformer.menuIteamtoMenuResponse(fooditeam)).collect(Collectors.toList());

    }
    public List<MenuResponse>top5ChepestFood(int id)
    {
        if(!validationUtill.restaurantValidation(id))
            throw new RestaurantNotFoundExceptions("restaurant not avaliable .. please search register name");
        Restaurant restaurant=restaurantRepository.findById(id).get();
        List<MenuIteam>menuIteamList=menuIteamRepository.findTop5ByRestaurantOrderByPriceAsc(restaurant);
        return menuIteamList.stream().map(fooditeam -> MenuTransformer.menuIteamtoMenuResponse(fooditeam)).collect(Collectors.toList());

    }

}
