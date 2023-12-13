package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.responsedto.CartResponse;
import com.project.foodjateApplication.models.Cart;

import java.util.ArrayList;

public class CartTransformer {
    public static CartResponse cartToCartresponse(Cart cart)
    {
        return CartResponse.builder()
                .carttotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
}
