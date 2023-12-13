package com.project.foodjateApplication.service;

import com.project.foodjateApplication.dto.responsedto.OrderResponse;
import com.project.foodjateApplication.exceptions.CardIsEmptyExceptions;
import com.project.foodjateApplication.exceptions.CustomberNotFoundException;
import com.project.foodjateApplication.models.*;
import com.project.foodjateApplication.repository.CustomberRepository;
import com.project.foodjateApplication.repository.DeliveryPartnerRepository;
import com.project.foodjateApplication.repository.OrderRepository;
import com.project.foodjateApplication.repository.RestaurantRepository;
import com.project.foodjateApplication.transformer.OrderTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    final OrderRepository orderRepository;
    final CustomberRepository customberRepository;
    final DeliveryPartnerRepository deliveryPartnerRepository;
   final RestaurantRepository restaurantRepository;
    public OrderService(OrderRepository orderRepository, CustomberRepository customberRepository, DeliveryPartnerRepository deliveryPartnerRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.customberRepository = customberRepository;

        this.deliveryPartnerRepository = deliveryPartnerRepository;
        this.restaurantRepository = restaurantRepository;
    }
    public OrderResponse addOrder(String mobileno)
    {
        Customber customber=customberRepository.findByContactNumber(mobileno);
        if(customber==null)
            throw new CustomberNotFoundException("cutomber not found");
        Cart cart=customber.getCart();
        if(cart.getFoodIteamList().size()==0)
            throw new CardIsEmptyExceptions("cart is empty please add fooditeam in cart ");

        //find delivery partner
        DeliveryPartner deliveryPartner=deliveryPartnerRepository.findRandomDeliveryPartner();

        //order entity

        OrderEntity order= OrderTransformer.prepaiaredOrder(cart);
        OrderEntity savedOrder=orderRepository.save(order);
        savedOrder.setCustomber(cart.getCustomber());
        savedOrder.setDeliveryPartner(deliveryPartner);
        savedOrder.setRestaurant(cart.getFoodIteamList().get(0).getMenuIteam().getRestaurant());


        customber.getOrderEntityList().add(savedOrder);
        deliveryPartner.getOrderEntityList().add(savedOrder);
        cart.getFoodIteamList().get(0).getMenuIteam().getRestaurant().getOrderEntityList().add(savedOrder);

        for(FoodIteam foodIteam:cart.getFoodIteamList())
        {
            foodIteam.setOrder(savedOrder);
            foodIteam.setCart(null);
        }
        clearcart(cart);

        customberRepository.save(customber);
        restaurantRepository.save(cart.getFoodIteamList().get(0).getMenuIteam().getRestaurant());
        deliveryPartnerRepository.save(deliveryPartner);

        return OrderTransformer.OrderToOrderResponse(savedOrder);





    }

    private  void clearcart(Cart cart)
    {
        cart.setCartTotal(0);
        cart.setFoodIteamList(new ArrayList<>());
    }
}
