package com.github.moinmarcell.backend;

import com.github.moinmarcell.backend.controller.DeadPersonController;
import com.github.moinmarcell.backend.controller.MongoUserController;
import com.github.moinmarcell.backend.service.DeadPersonService;
import com.github.moinmarcell.backend.service.MongoUserDetailsService;
import com.github.moinmarcell.backend.service.MongoUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private MongoUserService mongoUserService;
    @Autowired
    private MongoUserDetailsService mongoUserDetailsService;
    @Autowired
    private DeadPersonService deadPersonService;

    @Autowired
    private MongoUserController mongoUserController;
    @Autowired
    private DeadPersonController deadPersonController;

    @Test
    void contextLoads() {
        assertThat(mongoUserService).isNotNull();
        assertThat(mongoUserDetailsService).isNotNull();
        assertThat(deadPersonService).isNotNull();
        assertThat(mongoUserController).isNotNull();
        assertThat(deadPersonController).isNotNull();
    }

}
