package com.github.moinmarcell.backend.model;

import org.springframework.lang.NonNull;

public record DeadPersonRequest(
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String dateOfBirth,
        @NonNull
        String dateOfDeath,
        @NonNull
        String placeOfBirth,
        @NonNull
        String placeOfDeath,
        @NonNull
        Address address
) {
}
