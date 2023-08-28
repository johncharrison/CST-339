package com.gcu.service;

import com.gcu.model.User;

public interface LoginServiceInterface {
    public User findUser(String email);

    public boolean authenticate(User foundUser, String enteredPassword);

    public User login(String email, String password);
}
