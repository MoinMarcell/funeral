package com.github.moinmarcell.backend.controller;

import com.github.moinmarcell.backend.model.MongoUserRequest;
import com.github.moinmarcell.backend.model.MongoUserResponse;
import com.github.moinmarcell.backend.service.MongoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MongoUserController {

    private final MongoUserService mongoUserService;

    @PostMapping
    public MongoUserResponse signUp(@RequestBody MongoUserRequest mongoUserRequest) {
        return mongoUserService.createMongoUser(mongoUserRequest);
    }

}
