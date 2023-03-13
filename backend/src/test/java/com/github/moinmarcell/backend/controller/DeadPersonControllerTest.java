package com.github.moinmarcell.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.moinmarcell.backend.model.DeadPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeadPersonControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

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

    @Test
    @DirtiesContext
    @WithMockUser
    void createDeadPerson_whenSendingRequestWithMissingField_thenExpectStatusBadRequest() throws Exception {
        mockMvc.perform(post("/api/dead-persons").with(csrf()))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void getDeadPersonById_whenDeadPersonExist_thenReturnDeadPersonAndStatusOk() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/dead-persons")
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
                .andReturn();
        String jsonObj = result.getResponse().getContentAsString();
        DeadPerson deadPerson = objectMapper.readValue(jsonObj, DeadPerson.class);
        mockMvc.perform(get("/api/dead-persons/" + deadPerson.id()).with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void getDeadPersonById_whenDeadPersonNotExist_thenExpectStatusNotFound() throws Exception {
        mockMvc.perform(get("/api/dead-persons/1").with(csrf()))
                .andExpect(status().isNotFound());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void updateDeadPerson_whenDeadPersonExist_thenExpectStatusOkAndReturnUpdatedDeadPerson() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/dead-persons")
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
                .andReturn();
        String jsonObj = result.getResponse().getContentAsString();
        DeadPerson deadPerson = objectMapper.readValue(jsonObj, DeadPerson.class);
        mockMvc.perform(put("/api/dead-persons/" + deadPerson.id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "firstName": "firstName2",
                                  "lastName": "lastName2",
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
                          "firstName": "firstName2",
                          "lastName": "lastName2",
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
