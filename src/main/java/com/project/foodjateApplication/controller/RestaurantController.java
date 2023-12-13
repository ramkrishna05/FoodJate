package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.dto.requestdto.MenuRequest;
import com.project.foodjateApplication.dto.requestdto.RestaurantRequest;
import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.dto.responsedto.RestaurantResponse;
import com.project.foodjateApplication.exceptions.RestaurantNotFoundExceptions;
import com.project.foodjateApplication.models.Restaurant;
import com.project.foodjateApplication.service.RestaurantService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")

public class RestaurantController {
  final RestaurantService restaurantService;
@Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add-restaurant")
public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest)
    {
        RestaurantResponse restaurantResponse=restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
    }

    @PutMapping("/change-hotel-status")
    public ResponseEntity changeHotelStatus(@RequestParam int id)
    {
        try
        {
            String ans=restaurantService.changeHotelStatus(id);
            return new ResponseEntity(ans,HttpStatus.CREATED);

        }
        catch (RestaurantNotFoundExceptions e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/add-menuiteam")
    public ResponseEntity addmenuIteam(@RequestBody MenuRequest menuRequest)
    {
        try
        {
            RestaurantResponse restaurantResponse=restaurantService.addMenuIteam(menuRequest);
            return new ResponseEntity(restaurantResponse,HttpStatus.CREATED);

        }
        catch (RestaurantNotFoundExceptions e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }
    @GetMapping("/get-restaurant-menu/{id}")
    public ResponseEntity getRestaurantMenu(@PathVariable int id)
    {
        try
        {
            List<MenuResponse>menuResponseList=restaurantService.getRestaurantMenu(id);
            return  new ResponseEntity(menuResponseList,HttpStatus.FOUND);

        }
        catch (RestaurantNotFoundExceptions e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-menu-belowprice/{price}")
    public ResponseEntity getMenuBelowPrice(@RequestParam int id,@PathVariable double price)
    {
        try
        {
            List<MenuResponse>menuResponseList=restaurantService.getMenuBelowPrice(id,price);
            return new ResponseEntity(menuResponseList,HttpStatus.FOUND);

        }
        catch (RestaurantNotFoundExceptions e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }
}
