package com.github.moinmarcell.backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IdServiceTest {

    IdService idService = new IdService();

    @Test
    void generateId_whenGenerateId_thenReturnNonEmptyStringWithRandomId() {
        // GIVEN
        // WHEN
        String id = idService.generateId();
        // THEN
        assertNotNull(id);
    }
}