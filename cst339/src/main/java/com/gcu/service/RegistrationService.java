package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UserRepository;
import com.gcu.model.User;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    @Autowired
    private UserRepository repository;

    public void registerUser(User user) {

        repository.save(user);
        System.out.println("User registered: " + user.getEmail());
    }

}
