package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.model.DeadPersonRequest;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

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
}