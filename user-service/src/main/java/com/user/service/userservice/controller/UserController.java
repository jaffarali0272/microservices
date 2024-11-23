package com.user.service.userservice.controller;

import com.user.service.userservice.entity.User;
import com.user.service.userservice.externl.services.HotelService;
import com.user.service.userservice.externl.services.RattingService;
import com.user.service.userservice.rating.Hotel;
import com.user.service.userservice.rating.Ratting;
import com.user.service.userservice.service.UserService;
import com.user.service.userservice.service.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    @Autowired
    HotelService hotelService;

    @Autowired
    private RattingService rattingService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        Hotel hotel= Hotel.builder().name("Jaffar Resturent").location("Moro").build();
        hotelService.createHotel(hotel);

        Ratting ratting=Ratting.builder().rating(10).userId("").hotelId("").feedback("Enjoy alot  with Good Service").build();
        ratting.setHotelId(hotel.getId());
        ratting.setUserId(user1.getUserId());
        Ratting rating = rattingService.createRating(ratting);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
}

@GetMapping("/{userId}")
@CircuitBreaker(name="rattingHotelService",fallbackMethod = "rattingHotelFallback")
public ResponseEntity<User> getAllUsers(@PathVariable String userId){
User user=userService.getUser(userId);
   return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> rattingHotelFallback(String userId,Exception ex){
     logger.info("Fallback method is executed.."+ex.getMessage());

        User user=User.builder()
                .name("Dumy Name")
                .email("dumy@yahoo.com")
                .about("fallback method executed")
                .build();
        return ResponseEntity.ok(user);
    }




    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> user=userService.getAllUser();
        return ResponseEntity.ok(user);
    }



}
