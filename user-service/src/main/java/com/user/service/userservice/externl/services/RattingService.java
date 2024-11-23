package com.user.service.userservice.externl.services;

import com.user.service.userservice.rating.Ratting;
import jakarta.ws.rs.POST;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATTING-SERVICE")
public interface RattingService {

    @PostMapping("/ratting")
    Ratting createRating(Ratting ratting);

    //@PutMapping("/ratting/{hotelId}")
    //Ratting updateRating(@PathVariable("rattingId") Ratting ratting, String hotelId);

  //  @DeleteMapping("ratting/{rattingId}")
//    public void delete(@PathVariable String rattingId);

}
