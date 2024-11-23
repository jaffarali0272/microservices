package com.user.service.userservice.service;

import com.user.service.userservice.entity.User;
import com.user.service.userservice.exception.ResourceNotFoundException;
import com.user.service.userservice.externl.services.HotelService;
import com.user.service.userservice.rating.Hotel;
import com.user.service.userservice.rating.Ratting;
import com.user.service.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
   private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
    List<User> list=userRepository.findAll();
    return list;
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given Id Not found"+userId));
        Ratting[] rattingUser= restTemplate.getForObject("http://RATTING-SERVICE/ratting/users/"+user.getUserId(),Ratting[].class);
       // List<Ratting> forObject = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://localhost:8083/ratting/users/" + userId, Ratting[].class)));
        logger.info("Ratind {}",rattingUser);
       List<Ratting> list = Arrays.stream(rattingUser).toList();


//        List<Ratting> collect = Arrays.stream(rattingUser).collect(Collectors.toList());


        List<Ratting> rattingList=list.stream().map(ratting -> {
//            ResponseEntity<Hotel> hotelResp=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+ratting.getHotelId(),Hotel.class);
            //


            //Hotel body = hotelResp.getBody();
            Hotel body=hotelService.getHotel(ratting.getHotelId());
            ratting.setHotel(body);

          return ratting;
        }).collect(Collectors.toList());
       user.setRattingList(list);
        return user;
    }
}
