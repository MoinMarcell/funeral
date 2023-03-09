package com.github.moinmarcell.backend.controller;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.model.DeadPersonRequest;
import com.github.moinmarcell.backend.service.DeadPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public DeadPerson createDeadPerson(@RequestBody DeadPersonRequest deadPersonRequest) {
        return deadPersonService.createDeadPerson(deadPersonRequest);
    }

    @GetMapping("/{id}")
    public DeadPerson getDeadPersonById(@PathVariable String id) {
        return deadPersonService.getDeadPersonById(id);
    }
}
