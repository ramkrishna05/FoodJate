package com.project.foodjateApplication.repository;

import com.project.foodjateApplication.models.Customber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomberRepository extends JpaRepository<Customber,Integer> {
    Customber findByContactNumber(String  mobileno);

}
