package com.project.foodjateApplication.transformer;

import com.project.foodjateApplication.dto.requestdto.DeliveryPartnerRequest;
import com.project.foodjateApplication.models.DeliveryPartner;

import java.util.ArrayList;

public class DeliveryPartnerTransform {
    public static DeliveryPartner deliveryPartnerRequestToDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest)
    {
      return   DeliveryPartner.builder()
                .contactNumber(deliveryPartnerRequest.getMobileno())
                .gender(deliveryPartnerRequest.getGender())
                .name(deliveryPartnerRequest.getName())
                .orderEntityList(new ArrayList<>())
                .build();
    }
}
