package com.project.foodjateApplication.models;

import com.project.foodjateApplication.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_partner")

public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    @Size(min = 2,message = "name is small")
    @Size(max = 40,message = "name is big")
    String name;
    @Size(max = 10,min = 10)
    @Column(nullable = false,unique = true)
    String contactNumber;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @OneToMany(mappedBy = "deliveryPartner",cascade = CascadeType.ALL)
    List<OrderEntity>orderEntityList=new ArrayList<>();


}
