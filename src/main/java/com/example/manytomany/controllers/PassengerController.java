package com.example.manytomany.controllers;

import com.example.manytomany.dtos.PassengerDto;
import com.example.manytomany.services.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passengers") public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public PassengerDto addPassenger(@RequestBody PassengerDto passengerDto) {
        return passengerService.addPassenger(passengerDto);
    }
    @PostMapping("/addPassengerToRide/{passengerName}/{rideId}")
    public ResponseEntity<Object> addPassengerToRide(@PathVariable String passengerName, @PathVariable Long rideId){
        passengerService.addPassengerToRide(passengerName, rideId);
        return ResponseEntity.ok().build();
        //object kan ook void zijn
    }


//    @GetMapping("/{name}")
//    public UserDto getUser(@PathVariable String name) {
//        return userService.getUser(name);
//    }
}
