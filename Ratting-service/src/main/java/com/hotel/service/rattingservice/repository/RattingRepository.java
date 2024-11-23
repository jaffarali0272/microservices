package com.hotel.service.rattingservice.repository;

import com.hotel.service.rattingservice.entity.Ratting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RattingRepository extends JpaRepository<Ratting,String> {

    //custom finder methods
    List<Ratting> findByUserId(String userId);
    List<Ratting> findByHotelId(String hotelId);
}
