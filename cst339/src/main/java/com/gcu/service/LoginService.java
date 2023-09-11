package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.User;

@Service
public class LoginService {

    @Autowired
    private UserService service;

    public User findUser(String email) {
        return service.findByEmail(email);

    }

    public boolean authenticate(User foundUser, String enteredPassword) {
        if (foundUser != null) {
            return foundUser.getPassword().matches(enteredPassword);
        } else {
            return false;
        }

    }

    public User login(String email, String enteredPassword) {

        User u = this.findUser(email);
        boolean authenticated = this.authenticate(u, enteredPassword);

        if (authenticated) {
            return u;
        } else {
            return null;
        }
    }

}
