package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.dto.requestdto.FoodRequest;
import com.project.foodjateApplication.dto.responsedto.CartStatusResponse;
import com.project.foodjateApplication.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")

public class CartController {

    final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/add-fooditeam-in-cart")
    public ResponseEntity addFoodIteamInCart(@RequestBody FoodRequest foodRequest)
    {
        try
        {
            CartStatusResponse cartStatusResponse=cartService.addFoodIteamInCart(foodRequest);
            return new ResponseEntity(cartStatusResponse, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
