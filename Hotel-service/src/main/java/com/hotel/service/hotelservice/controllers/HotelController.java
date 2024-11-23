package com.hotel.service.hotelservice.controllers;

import com.hotel.service.hotelservice.entity.Hotel;
import com.hotel.service.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getAllHotels(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getHotelsByIs(hotelId));

    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getHotel() {
        List<Hotel> hotel = hotelService.getAllHotels();
        return ResponseEntity.ok(hotel);

    }
}