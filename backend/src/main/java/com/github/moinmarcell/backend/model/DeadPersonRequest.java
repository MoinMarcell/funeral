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
        String street,
        @NonNull
        String houseNumber,
        @NonNull
        String zipCode,
        @NonNull
        String city,
        @NonNull
        String country
) {
}
