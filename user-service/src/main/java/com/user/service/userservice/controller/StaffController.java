package com.user.service.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> staff(){
List<String> list=List.of("Jaffar","Zaffar","Bakhat Ali");
        return   new ResponseEntity<>(list, HttpStatus.OK);
    }

}
