package com.user.service.userservice.rating;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
