package com.gcu.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.User;

@Service
public class UserDao implements DaoInterface<User> {

    @Override
    public List<User> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public User get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public User create(User model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public User update(int id, User model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public User findUserByEmail(String email) {
        // query db for email, return User
        return new User("Firstname", "LastName", email, "password12345");
    }

}
