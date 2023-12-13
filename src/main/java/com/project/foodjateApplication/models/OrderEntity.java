package com.project.foodjateApplication.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_entity")

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String orderId;
    double  orderTotal;
    @CreationTimestamp
    Date orderTime;
  @ManyToOne
    @JoinColumn
    Customber customber;
  @ManyToOne
    @JoinColumn
    DeliveryPartner deliveryPartner;
  @ManyToOne
    @JoinColumn
    Restaurant restaurant;
 @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<FoodIteam>foodIteamList=new ArrayList<>();

}
