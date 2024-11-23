package com.hotel.service.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="hotel")
@Entity
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;



}
