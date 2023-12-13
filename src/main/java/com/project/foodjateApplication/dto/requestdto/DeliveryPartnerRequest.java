package com.project.foodjateApplication.dto.requestdto;

import com.project.foodjateApplication.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartnerRequest {
    String name;
    String mobileno;
    Gender gender;
}
