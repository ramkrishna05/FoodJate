package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.dto.requestdto.DeliveryPartnerRequest;
import com.project.foodjateApplication.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-partner")
public class DeliveryPartnerController {
    final DeliveryPartnerService deliveryPartnerService;
@Autowired
    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }
    @PostMapping("/add-delivery-partner")
    public ResponseEntity addDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest)
    {
        String response=deliveryPartnerService.addDeliveryPartner(deliveryPartnerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
