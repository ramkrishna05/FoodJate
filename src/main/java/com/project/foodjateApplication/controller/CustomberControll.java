package com.project.foodjateApplication.controller;

import com.project.foodjateApplication.dto.requestdto.CustomberRequest;
import com.project.foodjateApplication.dto.responsedto.CustomberResponse;
import com.project.foodjateApplication.service.CustomberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customber")
public class CustomberControll {
   final  CustomberService customberService;
    @Autowired
    public CustomberControll(CustomberService customberService) {
        this.customberService = customberService;
    }

    @PostMapping("/add-customber")
    public ResponseEntity addCustomber(@RequestBody CustomberRequest customberRequest)
    {
        CustomberResponse customberResponse=customberService.addCustomber(customberRequest);
        return new ResponseEntity(customberResponse, HttpStatus.CREATED);

    }


}
