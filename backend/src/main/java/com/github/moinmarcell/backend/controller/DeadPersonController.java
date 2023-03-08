package com.github.moinmarcell.backend.controller;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.service.DeadPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dead-persons")
@RequiredArgsConstructor
public class DeadPersonController {

    private final DeadPersonService deadPersonService;

    @GetMapping
    public List<DeadPerson> getAllDeadPersons() {
        return deadPersonService.getAllDeadPersons();
    }

}
