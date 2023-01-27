package com.example.manytomany.services;

import com.example.manytomany.dtos.PassengerDto;
import com.example.manytomany.exceptions.RecordNotFoundException;
import com.example.manytomany.models.Passenger;
import com.example.manytomany.repositories.PassengerRepository;
import com.example.manytomany.repositories.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final RideRepository rideRepository;

    public PassengerService(PassengerRepository passengerRepository, RideRepository rideRepository) {
        this.passengerRepository = passengerRepository;
        this.rideRepository = rideRepository;
    }

    public PassengerDto addPassenger(PassengerDto passengerDto) {
        Passenger passenger = transferToPassenger(passengerDto);
        passengerRepository.save(passenger);
        return passengerDto;
    }

    public static PassengerDto transferToDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerName(passenger.getPassengerName());
        passengerDto.setEmail(passenger.getEmail());
//        passengerDto.setRides(passenger.getRides());
        return passengerDto;
    }

    public Passenger transferToPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setPassengerName(passengerDto.getPassengerName());
        passenger.setEmail(passengerDto.getEmail());

//        List<Ride> rides = new ArrayList<>();
//        for (Long rideId : userDto.getRides().get(rides)) {
//            Optional<Ride> ride = rideRepository.findById(rideId);
//            if(ride.isPresent()) {
//                rides.add(ride.get());
//            }
//        }
//        user.setRides(rides);

        return passenger;
    }

    public void addPassengerToRide(String passengerName, Long id) {
        var optionalRide = rideRepository.findById(id);
        var optionalPassenger = passengerRepository.findByPassengerName(passengerName);

        if(optionalRide.isPresent() && optionalPassenger.isPresent()) {
            var ride = optionalRide.get();
            var passenger = optionalPassenger.get();

            passenger.getRides().add(ride);
            ride.getPassengers().add(passenger);

            passengerRepository.save(passenger);
            rideRepository.save(ride);
        } else {
            throw new RecordNotFoundException();
        }
    }
    }

