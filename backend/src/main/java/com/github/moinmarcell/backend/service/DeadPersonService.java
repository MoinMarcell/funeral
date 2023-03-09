package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.model.DeadPersonRequest;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchElementException("Dead Person with id " + id + " not found"));
    }

    public DeadPerson createDeadPerson(DeadPersonRequest deadPersonRequest) {

        if (deadPersonRequest == null) {
            throw new IllegalArgumentException("Dead Person must not be null");
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
        DeadPerson deadPerson = getDeadPersonById(id);

        DeadPerson updatedDeadPerson = new DeadPerson(
                deadPerson.id(),
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
        deadPersonRepository.save(updatedDeadPerson);

        return updatedDeadPerson;
    }

}
