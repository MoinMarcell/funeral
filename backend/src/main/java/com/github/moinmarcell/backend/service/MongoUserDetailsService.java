package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.MongoUser;
import com.github.moinmarcell.backend.repository.MongoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {

    private final MongoUserRepository mongoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MongoUser mongoUser = mongoUserRepository.findMongoUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(
                mongoUser.email(),
                mongoUser.password(),
                List.of(new SimpleGrantedAuthority("ROLE_" + mongoUser.role()))
        );
    }

}
