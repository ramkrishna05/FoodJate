package com.project.foodjateApplication.models;

import jakarta.persistence.*;
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
@Table(name = "cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double  cartTotal;
    @OneToOne
    @JoinColumn
    Customber customber;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<FoodIteam>foodIteamList=new ArrayList<>();
}
