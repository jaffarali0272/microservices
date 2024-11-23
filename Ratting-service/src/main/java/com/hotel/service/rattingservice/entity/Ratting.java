package com.hotel.service.rattingservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ratting")
public class Ratting {

    @Id
    private String rattingId;
    private String userId;
    private String hotelId;
    private int ratting;
    private String feedback;


}
