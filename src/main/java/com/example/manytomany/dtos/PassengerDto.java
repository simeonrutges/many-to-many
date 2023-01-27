package com.example.manytomany.dtos;

public class PassengerDto {
    public String passengerName;
    public String email;
//    public List<Ride> rides;
    // getters and setters

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Ride> getRides() {
//        return rides;
//    }
//
//    public void setRides(List<Ride> rides) {
//        this.rides = rides;
//    }
}
