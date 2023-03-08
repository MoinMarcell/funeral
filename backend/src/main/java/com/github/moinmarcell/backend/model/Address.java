package com.github.moinmarcell.backend.model;

public record Address(
        String street,
        String houseNumber,
        String zipCode,
        String city,
        String country
) {
}
