package com.hotel.service.rattingservice.controller;

import com.hotel.service.rattingservice.entity.Ratting;
import com.hotel.service.rattingservice.services.RattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratting")
public class RattingController {

    @Autowired
    private RattingService rattingService;

    @PostMapping
    public ResponseEntity<Ratting> createRattin(@RequestBody Ratting ratting){
        return ResponseEntity.status(HttpStatus.CREATED).body(rattingService.create(ratting));
    }

    @GetMapping
    public ResponseEntity<List<Ratting>> getRattings(){
        return ResponseEntity.ok(rattingService.getAllRatting());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratting>> getRattingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(rattingService.getAllRattingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Ratting>> getRattingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(rattingService.getAllRattingByHotelId(hotelId));
    }


}
