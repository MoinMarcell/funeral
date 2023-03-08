package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeadPersonService {

    private final DeadPersonRepository deadPersonRepository;

    public List<DeadPerson> getAllDeadPersons() {
        return deadPersonRepository.findAll();
    }

}
