package com.user.service.userservice;

import com.user.service.userservice.externl.services.RattingService;
import com.user.service.userservice.rating.Ratting;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
class UserServiceApplicationTests {
/*
    @Autowired
    private RattingService rattingService;


    @Test
    public void createRatting(){

        Ratting ratting=Ratting.builder().rating(10).userId("").hotelId("").feedback("New Envirenment with Good Service").build();
        Ratting rating = rattingService.createRating(ratting);
        System.out.println(rating);

    }*/
}
