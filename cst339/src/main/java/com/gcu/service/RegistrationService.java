package com.gcu.service;

import org.springframework.stereotype.Service;

import com.gcu.model.User;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    public void registerUser(User user) {

        System.out.println("User registered: " + user.getEmail());
    }

}
