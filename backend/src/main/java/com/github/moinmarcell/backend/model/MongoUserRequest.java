package com.github.moinmarcell.backend.model;

public record MongoUserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role
) {
}
