package com.project.foodjateApplication.exceptions;

public class RestaurantNotFoundExceptions extends RuntimeException
{
    public RestaurantNotFoundExceptions(String message)
    {
        super(message);
    }
}
