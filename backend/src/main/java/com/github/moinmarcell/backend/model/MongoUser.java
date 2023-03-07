package com.github.moinmarcell.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection = "users")
public record MongoUser(
        @Id
        @NonNull
        String id,
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @Indexed(unique = true)
        @NonNull
        String email,
        @NonNull
        String password,
        @NonNull
        String role
) {
}
