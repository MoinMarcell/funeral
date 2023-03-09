package com.github.moinmarcell.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeadPersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    @WithMockUser
    void getAllDeadPersons_whenListEmpty_thenExpectStatusOkAndContentEmptyList() throws Exception {
        mockMvc.perform(get("/api/dead-persons").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void createDeadPerson_whenSendingRequest_thenExpectStatusOkAndReturnSavedDeadPerson() throws Exception {
        mockMvc.perform(post("/api/dead-persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "firstName": "firstName",
                                  "lastName": "lastName",
                                  "dateOfBirth": "dateOfBirth",
                                  "dateOfDeath": "dateOfDeath",
                                  "placeOfBirth": "placeOfBirth",
                                  "placeOfDeath": "placeOfDeath",
                                  "street": "street",
                                  "houseNumber": "houseNumber",
                                  "zipCode": "zipCode",
                                  "city": "city",
                                  "country": "country"
                                }
                                """)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "firstName": "firstName",
                          "lastName": "lastName",
                          "dateOfBirth": "dateOfBirth",
                          "dateOfDeath": "dateOfDeath",
                          "placeOfBirth": "placeOfBirth",
                          "placeOfDeath": "placeOfDeath",
                          "street": "street",
                          "houseNumber": "houseNumber",
                          "zipCode": "zipCode",
                          "city": "city",
                          "country": "country"
                        }
                        """));
    }
}