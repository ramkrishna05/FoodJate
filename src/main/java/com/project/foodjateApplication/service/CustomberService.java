package com.project.foodjateApplication.service;

import com.project.foodjateApplication.dto.requestdto.CustomberRequest;
import com.project.foodjateApplication.dto.responsedto.CustomberResponse;
import com.project.foodjateApplication.models.Cart;
import com.project.foodjateApplication.models.Customber;
import com.project.foodjateApplication.repository.CustomberRepository;
import com.project.foodjateApplication.transformer.CustomberTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomberService {
    final CustomberRepository customberRepository;

    @Autowired
    public CustomberService(CustomberRepository customberRepository) {
        this.customberRepository = customberRepository;
    }
    public  CustomberResponse addCustomber(CustomberRequest customberRequest)
    {
        Customber customber= CustomberTransformer.CustomberrequestTOCustomber(customberRequest);
        Cart cart=Cart.builder()
                .cartTotal(0)
                .customber(customber)
                .build();
        customber.setCart(cart);
        Customber customber1=customberRepository.save(customber);
        return CustomberTransformer.CustombertoCustomberResponse(customber1);

    }
}
