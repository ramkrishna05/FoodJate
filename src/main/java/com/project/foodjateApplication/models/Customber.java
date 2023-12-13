package com.project.foodjateApplication.models;

import com.project.foodjateApplication.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "customber")

public class Customber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id;
    @Size(min = 2,message = "{validation.name.size.too_short}")
     @Size(max = 40,message = "{validation.name.size.too_long}")
    String name;
    @Email
    @Column(unique = true,nullable = false)
    String email;
    String address;
    @Column(unique = true,nullable = false)
    @Size(min = 10,max = 10)
    String contactNumber;
   @Enumerated(EnumType.STRING)
    Gender gender;
   @OneToMany(mappedBy = "customber",cascade =CascadeType.ALL )
    List<OrderEntity>orderEntityList=new ArrayList<>();
   @OneToOne(mappedBy = "customber",cascade = CascadeType.ALL)
    Cart cart;



}
