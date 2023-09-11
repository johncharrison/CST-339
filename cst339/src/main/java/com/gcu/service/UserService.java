package com.gcu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UserRepository;
import com.gcu.model.User;

@Service
public class UserService implements ServiceInterface<User> {
    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> query = repository.findById(id);
        if (query.isPresent()) {
            User u = query.get();
            return u;
        } else {
            System.out.println("User with ID: " + id + " does not exist.");
            return null;
        }
    }

    @Override
    public User save(User user) {

        try {
            User u = repository.findByEmail(user.getEmail());
            if (u == null) {
                System.out.println("User registered: " + user.getEmail());
                return repository.save(user);
            } else {
                System.out.println("Account with that email already exists");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        Optional<User> query = repository.findById(user.getId());
        if (query.isPresent()) {
            User u = query.get();
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            return repository.save(u);
        } else {
            System.out.println("User does not exist");
            return null;
        }

    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
