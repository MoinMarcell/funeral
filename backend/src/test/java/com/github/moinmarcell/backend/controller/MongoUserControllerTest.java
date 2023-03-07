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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MongoUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    @WithMockUser(username = "test", password = "test", roles = "ADMIN")
    void signUp_whenUserNotExist_thenStatusOkAndExpectContentMongoUserResponse() throws Exception {
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                                    {
                                                        "firstName": "FirstName",
                                                        "lastName": "LastName",
                                                        "email": "mail@mail.com",
                                                        "password": "password"
                                }
                                                    """
                        )
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                {
                                    "firstName": "FirstName",
                                    "lastName": "LastName",
                                    "email": "mail@mail.com",
                                    "role": "USER"
                                    }
                                """
                ));
    }

}