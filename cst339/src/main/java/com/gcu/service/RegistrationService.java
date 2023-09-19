package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.User;

@Service
public class RegistrationService {

    @Autowired
    private UserService service;

    public User registerUser(User u) {
        return service.save(u);
    }

}
