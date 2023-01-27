package com.example.manytomany.repositories;

import com.example.manytomany.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RideRepository extends JpaRepository<Ride, Long> {

    List<Ride> findAllRidesByNameEqualsIgnoreCase(String name);

}
