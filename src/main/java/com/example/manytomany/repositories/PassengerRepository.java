package com.example.manytomany.repositories;

import com.example.manytomany.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findByPassengerName(String passengerName);

}
