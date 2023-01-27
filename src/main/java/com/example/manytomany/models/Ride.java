package com.example.manytomany.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "rides")

//            (cascade = CascadeType.ALL)
//    @JoinTable(name = "ride_user", joinColumns = @JoinColumn(name = "ride_id"), inverseJoinColumns = @JoinColumn(name = "user_name", referencedColumnName = "name"))
    List<Passenger> passengers;
    // getters and setters


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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
