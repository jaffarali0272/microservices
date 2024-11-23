package com.hotel.service.hotelservice.services;

import com.hotel.service.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelsByIs(String id );


}
