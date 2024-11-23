package com.user.service.userservice.entity;

import com.user.service.userservice.rating.Ratting;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "micro-user")
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Ratting> rattingList=new ArrayList<>();

}
