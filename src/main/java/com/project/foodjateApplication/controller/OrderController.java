package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.dto.responsedto.OrderResponse;
import com.project.foodjateApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    final OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("add/mobile/{mobileno}")
    public ResponseEntity addOrder(@PathVariable("mobileno") String mobileno)
    {
       try
       {
         OrderResponse orderResponse= orderService.addOrder(mobileno);
         return new ResponseEntity(orderResponse, HttpStatus.CREATED);
       }
       catch (Exception e)
       {
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
