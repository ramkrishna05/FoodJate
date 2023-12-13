package com.project.foodjateApplication.dto.requestdto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FoodRequest {
    int requariedQuaintity;
    String  mobileno;
    int menuid;
}
