package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.MongoUser;
import com.github.moinmarcell.backend.repository.MongoUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MongoUserDetailsServiceTest {

    MongoUserRepository mongoUserRepository = mock(MongoUserRepository.class);
    MongoUserDetailsService mongoUserDetailsService = new MongoUserDetailsService(mongoUserRepository);

    @Test
    void loadUserByUsername_whenUserExist_thenReturnUser() {
        // GIVEN
        String email = "test@test.de";
        MongoUser expected = new MongoUser(
                "1",
                "FirstName",
                "LastName",
                email,
                "password",
                "USER");
        mongoUserRepository.save(expected);
        // WHEN
        when(mongoUserRepository.findMongoUserByEmail(email)).thenReturn(java.util.Optional.of(expected));
        UserDetails actual = mongoUserDetailsService.loadUserByUsername(email);
        // THEN
        verify(mongoUserRepository, times(1)).findMongoUserByEmail(email);
        assertEquals(expected.email(), actual.getUsername());
    }
}