package com.project.foodjateApplication.service;

import com.project.foodjateApplication.dto.requestdto.FoodRequest;
import com.project.foodjateApplication.dto.responsedto.CartStatusResponse;
import com.project.foodjateApplication.dto.responsedto.FoodResponse;
import com.project.foodjateApplication.exceptions.CustomberNotFoundException;
import com.project.foodjateApplication.exceptions.FoodIsNotAvailableExceptions;
import com.project.foodjateApplication.exceptions.OutOfStockException;
import com.project.foodjateApplication.models.*;
import com.project.foodjateApplication.repository.CartRepository;
import com.project.foodjateApplication.repository.CustomberRepository;
import com.project.foodjateApplication.repository.FoodRepository;
import com.project.foodjateApplication.repository.MenuIteamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CartService {
    final CustomberRepository customberRepository;
    final MenuIteamRepository menuIteamRepository;
    final  FoodRepository foodRepository;
    final CartRepository cartRepository;
@Autowired
    public CartService(CustomberRepository customberRepository, MenuIteamRepository menuIteamRepository, FoodRepository foodRepository, CartRepository cartRepository) {
        this.customberRepository = customberRepository;
    this.menuIteamRepository = menuIteamRepository;
    this.foodRepository = foodRepository;
    this.cartRepository = cartRepository;
}
    public CartStatusResponse addFoodIteamInCart(FoodRequest foodRequest)
    {
        Customber customber=customberRepository.findByContactNumber(foodRequest.getMobileno());
        if(customber==null)
        {
            throw new CustomberNotFoundException("customber not found");
        }
        Optional<MenuIteam>optionalMenuIteam=menuIteamRepository.findById(foodRequest.getMenuid());
        if(optionalMenuIteam.isEmpty())
        {
            throw new FoodIsNotAvailableExceptions("food is not available ");
        }
        MenuIteam menuIteam=optionalMenuIteam.get();
        if(!menuIteam.isAvailable())
        {
            throw new OutOfStockException("food is out of stock");
        }
        Cart cart=customber.getCart();
        if(cart.getFoodIteamList().size()!=0)
        {
            Restaurant currRestaurant=cart.getFoodIteamList().get(0).getMenuIteam().getRestaurant();
            Restaurant newRestaurant=menuIteam.getRestaurant();

            if(!currRestaurant.equals(newRestaurant))
            {
                for (FoodIteam foodIteam : cart.getFoodIteamList())
                {
                   foodIteam.setCart(null);
                   foodIteam.setMenuIteam(null);
                   foodIteam.setOrder(null);
                }
                cart.getFoodIteamList().clear();
                cart.setCartTotal(0);
                foodRepository.deleteAll(cart.getFoodIteamList());



            }
        }
       FoodIteam savedFoodIteam=null;
        boolean isalreadyexists=false;
        if (cart.getFoodIteamList().size()!=0)
        {
            for (FoodIteam foodIteam:cart.getFoodIteamList())
            {
                if(foodIteam.getMenuIteam().getId()==menuIteam.getId())
                {
                    savedFoodIteam=foodIteam;
                    int curr=foodIteam.getRequiredQuantity();
                    foodIteam.setRequiredQuantity(curr+foodRequest.getRequariedQuaintity());
                    isalreadyexists=true;
                    break;
                }
            }
        }
        if(!isalreadyexists)
        {
        FoodIteam foodIteam=    FoodIteam.builder()
                    .menuIteam(menuIteam)
                    .requiredQuantity(foodRequest.getRequariedQuaintity())
                    .totalcost(foodRequest.getRequariedQuaintity()*menuIteam.getPrice())
                    .build();

                savedFoodIteam=foodRepository.save(foodIteam);
               cart.getFoodIteamList().add(savedFoodIteam);
               menuIteam.getFoodIteamList().add(savedFoodIteam);
                foodIteam.setCart(cart);
        }
        double cartTOtal=0;
        for (FoodIteam foodIteam:cart.getFoodIteamList())
        {
            cartTOtal+=foodIteam.getRequiredQuantity()*foodIteam.getMenuIteam().getPrice();

        }
        cart.setCartTotal(cartTOtal);
        Cart cart1 =cartRepository.save(cart);
        MenuIteam menuIteam1=menuIteamRepository.save(menuIteam);

        List<FoodResponse>foodResponses=new ArrayList<>();
        for(FoodIteam foodIteam:cart1.getFoodIteamList())
        {
            FoodResponse foodResponse=FoodResponse.builder()
                    .foodCategory(foodIteam.getMenuIteam().getFoodCategory())
                    .veg(foodIteam.getMenuIteam().isVeg())
                    .price(foodIteam.getMenuIteam().getPrice())
                    .dishname(foodIteam.getMenuIteam().getDishName())
                    .quantityadded(foodIteam.getRequiredQuantity())
                    .build();
            foodResponses.add(foodResponse);
        }
        return CartStatusResponse.builder()
                .carttotal(cart1.getCartTotal())
                .address(cart1.getCustomber().getAddress())
                .contactNumber(cart1.getCustomber().getContactNumber())
                .name(cart1.getCustomber().getName())
                .restuarantname(menuIteam1.getRestaurant().getName())
                .foodItems(foodResponses)
                .build();


    }
}
