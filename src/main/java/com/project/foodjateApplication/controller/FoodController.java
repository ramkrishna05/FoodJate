package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.Enum.FoodCategory;
import com.project.foodjateApplication.dto.responsedto.MenuResponse;
import com.project.foodjateApplication.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    final FoodService foodService;
@Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
  @GetMapping("/get-fooditeam-categorywise/{foodCategory}")
  public ResponseEntity getFoodCategoryWise(@PathVariable FoodCategory foodCategory)
  {
      List<MenuResponse>menuResponseList=foodService.getFoodCategoryWise(foodCategory);
      return new ResponseEntity(menuResponseList, HttpStatus.FOUND);

  }
  @GetMapping("/get-allveg")
    public ResponseEntity getAllVegFood()
  {
      List<MenuResponse>menuResponseList=foodService.getAllVegFood();
      return new ResponseEntity(menuResponseList,HttpStatus.FOUND);

  }
  @GetMapping("top5chepest/byrestaurant")
    public ResponseEntity top5ChepestFood(@RequestParam int id)
  {
      List<MenuResponse>menuResponseList=foodService.top5ChepestFood(id);
      return new ResponseEntity(menuResponseList,HttpStatus.FOUND);

  }

}
