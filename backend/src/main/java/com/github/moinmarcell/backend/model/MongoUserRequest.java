package com.github.moinmarcell.backend.model;

import org.springframework.lang.NonNull;

public record MongoUserRequest(
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String email,
        @NonNull
        String password
) {
}
