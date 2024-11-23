package com.hotel.service.rattingservice.services;

import com.hotel.service.rattingservice.entity.Ratting;

import java.util.List;

public interface RattingService {

    Ratting create(Ratting ratting);

    List<Ratting> getAllRatting();

    List<Ratting> getAllRattingByUserId(String userId);
    List<Ratting> getAllRattingByHotelId(String hotelId);


}
