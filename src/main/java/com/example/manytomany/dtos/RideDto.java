package com.example.manytomany.dtos;

import com.example.manytomany.models.Passenger;

import java.util.List;

public class RideDto {
    public Long id;
    public String name;
//    public List<Passenger> passengers;
//     getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Passenger> getPassengers() {
//        return passengers;
//    }
//    public void setPassengers(List<Passenger> passengers) {
//        this.passengers = passengers;
//    }
}
