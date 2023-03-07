package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.MongoUser;
import com.github.moinmarcell.backend.model.MongoUserRequest;
import com.github.moinmarcell.backend.model.MongoUserResponse;
import com.github.moinmarcell.backend.repository.MongoUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MongoUserServiceTest {

    MongoUserRepository mongoUserRepository = mock(MongoUserRepository.class);
    PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    IdService idService = mock(IdService.class);
    MongoUserService mongoUserService = new MongoUserService(mongoUserRepository, idService, passwordEncoder);

    @Test
    void createMongoUser_whenUserNotExist_thenReturnNewUser() {
        // GIVEN
        MongoUserRequest userToAdd = new MongoUserRequest(
                "FirstName",
                "LastName",
                "mail@mail.com",
                "password"
        );
        MongoUser mongoUser = new MongoUser(
                "1",
                "FirstName",
                "LastName",
                "mail@mail.com",
                "password",
                "USER"
        );
        MongoUserResponse expectedUser = new MongoUserResponse(
                "1",
                "FirstName",
                "LastName",
                "mail@mail.com",
                "USER"
        );
        // WHEN
        when(mongoUserRepository.save(mongoUser)).thenReturn(mongoUser);
        when(idService.generateId()).thenReturn("1");
        when(passwordEncoder.encode("password")).thenReturn("password");
        MongoUserResponse actualUser = mongoUserService.createMongoUser(userToAdd);
        // THEN
        verify(mongoUserRepository, times(1)).save(mongoUser);
        verify(idService, times(1)).generateId();
        verify(passwordEncoder, times(1)).encode("password");
        assertEquals(expectedUser, actualUser);
    }
}