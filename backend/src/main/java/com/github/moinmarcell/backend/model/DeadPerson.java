package com.github.moinmarcell.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection = "deadPersons")
public record DeadPerson(
        @Id
        @NonNull
        String id,
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
