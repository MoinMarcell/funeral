package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.model.DeadPersonRequest;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeadPersonService {

    private final DeadPersonRepository deadPersonRepository;
    private final IdService idService;

    public List<DeadPerson> getAllDeadPersons() {
        return deadPersonRepository.findAll();
    }

    public DeadPerson getDeadPersonById(String id) {
        return deadPersonRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dead Person not found"));
    }

    public DeadPerson createDeadPerson(DeadPersonRequest deadPersonRequest) {

        if (deadPersonRequest == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dead Person must not be null");
        }

        DeadPerson deadPersonToSave = new DeadPerson(
                idService.generateId(),
                deadPersonRequest.firstName(),
                deadPersonRequest.lastName(),
                deadPersonRequest.dateOfBirth(),
                deadPersonRequest.dateOfDeath(),
                deadPersonRequest.placeOfBirth(),
                deadPersonRequest.placeOfDeath(),
                deadPersonRequest.street(),
                deadPersonRequest.houseNumber(),
                deadPersonRequest.zipCode(),
                deadPersonRequest.city(),
                deadPersonRequest.country()
        );

        deadPersonRepository.save(deadPersonToSave);

        return deadPersonToSave;
    }

    public DeadPerson updateDeadPerson(String id, DeadPersonRequest deadPersonRequest) {

        if (deadPersonRequest == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dead Person must not be null");
        }

        DeadPerson deadPersonToUpdate = new DeadPerson(
                id,
                deadPersonRequest.firstName(),
                deadPersonRequest.lastName(),
                deadPersonRequest.dateOfBirth(),
                deadPersonRequest.dateOfDeath(),
                deadPersonRequest.placeOfBirth(),
                deadPersonRequest.placeOfDeath(),
                deadPersonRequest.street(),
                deadPersonRequest.houseNumber(),
                deadPersonRequest.zipCode(),
                deadPersonRequest.city(),
                deadPersonRequest.country()
        );

        deadPersonRepository.save(deadPersonToUpdate);

        return deadPersonToUpdate;
    }
}
