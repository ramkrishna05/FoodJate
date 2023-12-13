package com.project.foodjateApplication.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomberResponse {
    String  name;
    String contactNumber;
    String address;
    CartResponse cartResponse;


}
