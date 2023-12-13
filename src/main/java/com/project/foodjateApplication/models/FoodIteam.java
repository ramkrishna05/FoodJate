package com.project.foodjateApplication.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "food_iteam")


public class FoodIteam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int requiredQuantity;
    double  totalcost;
    @ManyToOne
    @JoinColumn
    Cart cart;
    @ManyToOne
    @JoinColumn
    MenuIteam menuIteam;
    @ManyToOne
    @JoinColumn
    OrderEntity order;

}
