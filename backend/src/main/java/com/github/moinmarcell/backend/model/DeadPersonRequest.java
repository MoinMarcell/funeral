package com.github.moinmarcell.backend.model;

public record DeadPersonRequest(
        String firstName,
        String lastName,
        String dateOfBirth,
        String dateOfDeath,
        String placeOfBirth,
        String placeOfDeath,
        Address address
) {
}
