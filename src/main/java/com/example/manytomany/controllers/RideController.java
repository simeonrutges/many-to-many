package com.example.manytomany.controllers;

import com.example.manytomany.dtos.RideDto;
import com.example.manytomany.services.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

//    @PostMapping
//    public RideDto addRide(@RequestBody RideDto rideDto) {
//        return rideService.addRide(rideDto);
//    }

@PostMapping
public ResponseEntity<Object> addRide(@RequestBody RideDto rideDto) {
        RideDto dto = rideService.addRide(rideDto);
    return ResponseEntity.created(null).body(dto);
}

//    @GetMapping("/{id}")
//    public RideDto getRide(@PathVariable Long id) {
//        return rideService.getRide(id);
//    }

    @GetMapping("")
    public ResponseEntity<List<RideDto>> getAllRides(@RequestParam(value = "name", required = false) Optional<String> name) {

        List<RideDto> dtos;

        if (name.isEmpty()){

            dtos = rideService.getAllRides();

        } else {

            dtos = rideService.getAllRidesByName(name.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RideDto> getRide(@PathVariable("id")Long id) {

        RideDto television = rideService.getRideById(id);

        return ResponseEntity.ok().body(television);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRide(@PathVariable Long id) {

        rideService.deleteRide(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRide(@PathVariable Long id, @Valid @RequestBody RideDto newRide) {

        RideDto dto = rideService.updateRide(id, newRide);

        return ResponseEntity.ok().body(dto);
    }



    // Onderstaande 2 methodes zijn endpoints om andere entiteiten toe te voegen aan de Television.
    // Dit is één manier om dit te doen, met één PathVariable en één RequestBody.
//    @PutMapping("/{id}/remotecontroller")
//    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id,@Valid @RequestBody IdInputDto input) {
//        rideService.assignRemoteControllerToTelevision(id, input.id);
//    }
//
//    //Dit is een andere manier om het te doen, met twee Pathvariables, maar het kan uiteraard ook anders.
//    @PutMapping("/{id}/{ciModuleId}")
//    public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
//        rideService.assignCIModuleToTelevision(id, ciModuleId);
//    }
//
//    // Deze methode is om alle wallbrackets op te halen die aan een bepaalde television gekoppeld zijn.
//    // Deze methode maakt gebruik van de televisionWallBracketService.
//    @GetMapping("/wallBrackets/{televisionId}")
//    public Collection<WallBracketDto> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
//        return televisionWallBracketService.getWallBracketsByTelevisionId(televisionId);
//    }

}
