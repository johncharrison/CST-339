package com.gcu.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gcu.data.repository.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByEmail(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("email not found"));
    }

}
