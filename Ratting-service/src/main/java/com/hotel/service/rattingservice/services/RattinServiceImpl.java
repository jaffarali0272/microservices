package com.hotel.service.rattingservice.services;

import com.hotel.service.rattingservice.entity.Ratting;
import com.hotel.service.rattingservice.repository.RattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RattinServiceImpl implements RattingService{

    @Autowired
    private RattingRepository rattingRepository;

    @Override
    public Ratting create(Ratting ratting) {
String rattingID= UUID.randomUUID().toString();
ratting.setRattingId(rattingID);
        return rattingRepository.save(ratting);
    }

    @Override
    public List<Ratting> getAllRatting() {
        return rattingRepository.findAll();
    }

    @Override
    public List<Ratting> getAllRattingByUserId(String userId) {
        return rattingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratting> getAllRattingByHotelId(String hotelId) {
        return rattingRepository.findByHotelId(hotelId);
    }
}
