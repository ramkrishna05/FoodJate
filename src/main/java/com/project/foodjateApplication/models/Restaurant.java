package com.project.foodjateApplication.models;

import com.project.foodjateApplication.Enum.RestaurantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "restaurant")

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Size(min = 2, message = "hotel name is invalide")
    @Size(max = 40,message = "hotel name is large")
    String name;
    String location;
    @Enumerated(EnumType.STRING)
    RestaurantCategory restaurantCategory;
    @Size(max = 10,min = 10)
    String contactNumber;
    boolean opend;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<MenuIteam>menuIteamList=new ArrayList<>();
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    List<OrderEntity>orderEntityList=new ArrayList<>();



}
