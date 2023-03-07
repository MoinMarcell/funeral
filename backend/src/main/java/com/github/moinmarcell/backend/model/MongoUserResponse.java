package com.github.moinmarcell.backend.model;

public record MongoUserResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        String role
) {
}
