package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.requestdto.CustomberRequest;
import com.project.foodjateApplication.dto.responsedto.CartResponse;
import com.project.foodjateApplication.dto.responsedto.CustomberResponse;
import com.project.foodjateApplication.models.Customber;

public class CustomberTransformer {
    public static Customber CustomberrequestTOCustomber(CustomberRequest customberRequest)
    {
      return   Customber.builder()
                .name(customberRequest.getName())
                .address(customberRequest.getAddress())
                .email(customberRequest.getEmail())
                .contactNumber(customberRequest.getContactNumber())
                .gender(customberRequest.getGender())
                .build();

    }

    public static CustomberResponse CustombertoCustomberResponse(Customber customber)
    {
        CartResponse cartResponse=CartTransformer.cartToCartresponse(customber.getCart());


     return    CustomberResponse.builder()
                .address(customber.getAddress())
                .name(customber.getName())
                .contactNumber(customber.getContactNumber())
                .cartResponse(cartResponse)
                .build();
    }
}
