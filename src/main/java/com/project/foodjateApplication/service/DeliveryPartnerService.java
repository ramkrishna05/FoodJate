package com.project.foodjateApplication.service;

import com.project.foodjateApplication.dto.requestdto.DeliveryPartnerRequest;
import com.project.foodjateApplication.models.DeliveryPartner;
import com.project.foodjateApplication.repository.DeliveryPartnerRepository;
import com.project.foodjateApplication.transformer.DeliveryPartnerTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {
    final DeliveryPartnerRepository deliveryPartnerRepository;
    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }
    public String addDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest )
    {
        DeliveryPartner deliveryPartner= DeliveryPartnerTransform.deliveryPartnerRequestToDeliveryPartner(deliveryPartnerRequest);
        DeliveryPartner deliveryPartner1=  deliveryPartnerRepository.save(deliveryPartner);
        return "your added succsesfully ";
    }
}
