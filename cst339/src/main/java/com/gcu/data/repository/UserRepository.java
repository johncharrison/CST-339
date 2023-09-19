package com.gcu.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcu.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE EMAIL=:email LIMIT 1", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);
}
