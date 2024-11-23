package com.user.service.userservice.service;

import com.user.service.userservice.entity.User;
import org.springframework.data.jpa.domain.QAbstractAuditable;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
