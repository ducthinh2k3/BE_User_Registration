package com.example.ia03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import java.util.Optional;

import com.example.ia03.repository.UserRepository;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.example.ia03.models.User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return User.builder()
                    .username(user.get().getEmail())
                    .password(user.get().getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(email);
        }
    }
    
}
