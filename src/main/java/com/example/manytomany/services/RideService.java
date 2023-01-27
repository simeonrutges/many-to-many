package com.example.manytomany.services;

import com.example.manytomany.dtos.RideDto;
import com.example.manytomany.exceptions.RecordNotFoundException;
import com.example.manytomany.models.Ride;
import com.example.manytomany.repositories.PassengerRepository;
import com.example.manytomany.repositories.RideRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService {
    private final RideRepository rideRepository;
    private final PassengerRepository passengerRepository;
    private final PassengerService passengerService;

    public RideService(RideRepository rideRepository, PassengerRepository passengerRepository, PassengerService passengerService) {
        this.rideRepository = rideRepository;
        this.passengerRepository = passengerRepository;
        this.passengerService = passengerService;
    }

    public RideDto addRide(RideDto dto) {
        Ride ride = transferToRide(dto);
        rideRepository.save(ride);
        return transferToDto(ride);
    }

    public Ride transferToRide(RideDto rideDto) {
        Ride ride = new Ride();
        ride.setName(rideDto.getName());

//        List<User> users = new ArrayList<>();
//        for (String username : rideDto.getUsers()) {
//            Optional<User> user = userRepository.findByUsername(username);
//            if (user.isPresent()) {
//                users.add(user.get());
//            }
//        }
//        ride.setUsers(users);

        return ride;
    }
    public RideDto transferToDto(Ride ride){
        RideDto dto = new RideDto();

        dto.setId(ride.getId());
        dto.setName(ride.getName());

        // Als extra op deze transfer methode, voegen we ook de relaties toe.
        // Hier moeten we eerst een null check voor doen,
        // omdat we anders in CIModule.transferToDto de get-methodes van "null" aanroepen en dat kan niet.

//        if(ride.getPassengers() != null){
//            dto.setPassengers(PassengerService.fromPassenger(ride.getPassengers()));
//        }

        return dto;
    }

    public List<RideDto> getAllRides() {
        List<Ride> rideList = rideRepository.findAll();
        return transferRideListToDtoList(rideList);
    }

    public List<RideDto> transferRideListToDtoList(List<Ride> rides){
        List<RideDto> rideDtoList = new ArrayList<>();

        for(Ride ride : rides) {
            RideDto dto = transferToDto(ride);
//            if(ride.getPassengers() != null){
//                dto.setPassengers(passengerService.transferToDto(ride.getPassengers()));
//            }
//            if(ride.getRemoteController() != null){
//                dto.setRemoteControllerDto(remoteControllerService.transferToDto(ride.getRemoteController()));
//            }
            rideDtoList.add(dto);
        }
        return rideDtoList;
    }

    public RideDto getRideById(Long id) {
        if (rideRepository.findById(id).isPresent()){
            Ride ride = rideRepository.findById(id).get();
            RideDto dto =transferToDto(ride);
//            if(ride.getPassengers() != null){
//                dto.setPassengers(passengerService.transferToDto(ride.getPassengers().get()));
//            }
//            if(ride.getRemoteController() != null){
//                dto.setRemoteControllerDto(remoteControllerService.transferToDto(ride.getRemoteController()));
//            }

            return transferToDto(ride);
        }
        else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    public List<RideDto> getAllRidesByName(String name) {
        List<Ride> rideList = rideRepository.findAllRidesByNameEqualsIgnoreCase(name);
        return transferRideListToDtoList(rideList);

    }

    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }

    public RideDto updateRide(Long id, RideDto newRide) {
        if (rideRepository.findById(id).isPresent()){

            Ride tv = rideRepository.findById(id).get();

            Ride tv1 = transferToRide(newRide);
            tv1.setId(tv.getId());

            rideRepository.save(tv1);

            return transferToDto(tv1);

        } else {

            throw new  RecordNotFoundException("geen rit gevonden");

        }
    }


//    public RideDto transferToDto(Ride ride) {
//        RideDto rideDto = new RideDto();
//        rideDto.setId(ride.getId());
//        rideDto.setName(ride.getName());
//        rideDto.setPassengers(ride.getPassengers());
//
//        return rideDto;
//    }
}
