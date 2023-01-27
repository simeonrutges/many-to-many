package com.example.manytomany.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Passenger {
    @Id
    private String passengerName;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Ride> rides;
//     getters and setters

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String username) {
        this.passengerName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
