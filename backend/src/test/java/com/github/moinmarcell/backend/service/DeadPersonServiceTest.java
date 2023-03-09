package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.model.DeadPersonRequest;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DeadPersonServiceTest {

    private final DeadPersonRepository deadPersonRepository = mock(DeadPersonRepository.class);
    private final IdService idService = mock(IdService.class);
    private final DeadPersonService deadPersonService = new DeadPersonService(deadPersonRepository, idService);

    @Test
    void getAllDeadPersons_whenListEmpty_thenReturnEmptyList() {
        // given
        List<DeadPerson> expected = Collections.emptyList();

        // when
        when(deadPersonRepository.findAll()).thenReturn(expected);
        List<DeadPerson> actual = deadPersonService.getAllDeadPersons();

        // then
        verify(deadPersonRepository, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void createDeadPerson_whenDeadPersonNotExist_thenSaveDeadPersonAndReturn() {
        // given
        DeadPerson expected = new DeadPerson(
                "id",
                "firstName",
                "lastName",
                "dateOfBirth",
                "dateOfDeath",
                "placeOfBirth",
                "placeOfDeath",
                "street",
                "houseNumber",
                "zipCode",
                "city",
                "country"

        );
        DeadPersonRequest deadPersonRequest = new DeadPersonRequest(
                "firstName",
                "lastName",
                "dateOfBirth",
                "dateOfDeath",
                "placeOfBirth",
                "placeOfDeath",
                "street",
                "houseNumber",
                "zipCode",
                "city",
                "country"
        );

        // when
        when(idService.generateId()).thenReturn("id");
        when(deadPersonRepository.save(expected)).thenReturn(expected);
        DeadPerson actual = deadPersonService.createDeadPerson(deadPersonRequest);

        // then
        verify(idService, times(1)).generateId();
        verify(deadPersonRepository, times(1)).save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void createDeadPerson_whenDeadPersonRequestIsNull_thenThrowIllegalArgumentException() {
        // given
        DeadPersonRequest deadPersonRequest = null;

        // then
        assertThrows(IllegalArgumentException.class, () -> deadPersonService.createDeadPerson(deadPersonRequest));
    }

    @Test
    void getDeadPersonById_whenDeadPersonExist_thenReturnDeadPerson() {
        // given
        DeadPerson expected = new DeadPerson(
                "id",
                "firstName",
                "lastName",
                "dateOfBirth",
                "dateOfDeath",
                "placeOfBirth",
                "placeOfDeath",
                "street",
                "houseNumber",
                "zipCode",
                "city",
                "country"

        );

        // when
        when(deadPersonRepository.findById("id")).thenReturn(Optional.of(expected));
        DeadPerson actual = deadPersonService.getDeadPersonById("id");

        // then
        verify(deadPersonRepository, times(1)).findById("id");
        assertEquals(expected, actual);
    }

    @Test
    void getDeadPersonById_whenDeadPersonNotExist_thenThrowNoSuchElementException() {
        // given
        String id = "id";

        // then
        assertThrows(NoSuchElementException.class, () -> deadPersonService.getDeadPersonById(id));
    }

    @Test
    void updateDeadPerson_whenDeadPersonExist_thenUpdateDeadPersonAndReturn() {
        // given
        DeadPerson existingDeadPerson = new DeadPerson(
                "id",
                "firstName",
                "lastName",
                "dateOfBirth",
                "dateOfDeath",
                "placeOfBirth",
                "placeOfDeath",
                "street",
                "houseNumber",
                "zipCode",
                "city",
                "country"

        );
        deadPersonRepository.save(existingDeadPerson);

        DeadPersonRequest deadPersonRequest = new DeadPersonRequest(
                "firstName2",
                "lastName2",
                "dateOfBirth2",
                "dateOfDeath2",
                "placeOfBirth2",
                "placeOfDeath2",
                "street2",
                "houseNumber2",
                "zipCode2",
                "city2",
                "country2"
        );
        DeadPerson expected = new DeadPerson(
                "id",
                "firstName2",
                "lastName2",
                "dateOfBirth2",
                "dateOfDeath2",
                "placeOfBirth2",
                "placeOfDeath2",
                "street2",
                "houseNumber2",
                "zipCode2",
                "city2",
                "country2"

        );

        // when
        when(deadPersonRepository.findById("id")).thenReturn(Optional.of(existingDeadPerson));
        when(deadPersonRepository.save(existingDeadPerson)).thenReturn(existingDeadPerson);
        DeadPerson actual = deadPersonService.updateDeadPerson("id", deadPersonRequest);

        // then
        verify(deadPersonRepository, times(1)).findById("id");
        verify(deadPersonRepository, times(1)).save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void updateDeadPerson_whenDeadPersonNotExist_thenThrowNoSuchElementException() {
        // given
        DeadPersonRequest deadPersonRequest = new DeadPersonRequest(
                "firstName2",
                "lastName2",
                "dateOfBirth2",
                "dateOfDeath2",
                "placeOfBirth2",
                "placeOfDeath2",
                "street2",
                "houseNumber2",
                "zipCode2",
                "city2",
                "country2"
        );
        String id = "id";

        // then
        assertThrows(NoSuchElementException.class, () -> deadPersonService.updateDeadPerson(id, deadPersonRequest));
    }
}