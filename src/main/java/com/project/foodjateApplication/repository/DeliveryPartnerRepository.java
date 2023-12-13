package com.project.foodjateApplication.repository;

import com.project.foodjateApplication.controller.DeliveryPartnerController;
import com.project.foodjateApplication.models.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner,Integer> {
    String findRandomPartner="select p from DeliveryPartner p order by RAND() LIMIT 1";

    @Query(value =findRandomPartner )
    DeliveryPartner findRandomDeliveryPartner();
}
