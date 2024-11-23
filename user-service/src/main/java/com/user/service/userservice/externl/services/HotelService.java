package com.user.service.userservice.externl.services;

import com.user.service.userservice.rating.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

    @PostMapping("/hotel")
    void createHotel(Hotel hotel);


}
