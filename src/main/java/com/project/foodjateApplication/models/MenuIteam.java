package com.project.foodjateApplication.models;

import com.project.foodjateApplication.Enum.FoodCategory;
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
@Table(name = "menu_iteam")

public class MenuIteam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String dishName;
    double price;
    @Enumerated(EnumType.STRING)
    FoodCategory foodCategory;
    boolean veg;
    boolean available;

    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
    @OneToMany(mappedBy = "menuIteam",cascade = CascadeType.ALL)
    List<FoodIteam>foodIteamList=new ArrayList<>();

}
