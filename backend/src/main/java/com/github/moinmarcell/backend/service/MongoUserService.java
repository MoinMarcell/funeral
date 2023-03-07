package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.MongoUser;
import com.github.moinmarcell.backend.model.MongoUserRequest;
import com.github.moinmarcell.backend.model.MongoUserResponse;
import com.github.moinmarcell.backend.repository.MongoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MongoUserService {

    private final MongoUserRepository mongoUserRepository;
    private final IdService idService;
    private final PasswordEncoder passwordEncoder;

    public MongoUserResponse createMongoUser(MongoUserRequest mongoUserRequest) {
        MongoUser mongoUserToSave = new MongoUser(
                idService.generateId(),
                mongoUserRequest.firstName(),
                mongoUserRequest.lastName(),
                mongoUserRequest.email(),
                passwordEncoder.encode(mongoUserRequest.password()),
                "USER"
        );

        try {
            mongoUserRepository.save(mongoUserToSave);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

        return new MongoUserResponse(
                mongoUserToSave.id(),
                mongoUserToSave.firstName(),
                mongoUserToSave.lastName(),
                mongoUserToSave.email(),
                mongoUserToSave.role()
        );
    }

}
