package com.gcu.service;

import org.springframework.stereotype.Service;

import com.gcu.data.UserDao;
import com.gcu.model.User;

@Service
public class LoginService implements LoginServiceInterface {

    private final UserDao dao;
    private User user;

    public LoginService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User findUser(String email) {
        return dao.findUserByEmail(email);

    }

    @Override
    public boolean authenticate(User foundUser, String enteredPassword) {
        // check to see if password from found user and entered password hashes match
        // if they do return true if not return false
        return foundUser.getPassword().matches(enteredPassword);

    }

    @Override
    public User login(String email, String enteredPassword) {
        this.user = this.findUser(email);
        boolean authenticated = this.authenticate(this.user, enteredPassword);

        if (authenticated) {
            return this.user;
        } else {
            return null;
        }
    }

}
