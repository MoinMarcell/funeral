package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.DeadPerson;
import com.github.moinmarcell.backend.repository.DeadPersonRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeadPersonServiceTest {

    private final DeadPersonRepository deadPersonRepository = mock(DeadPersonRepository.class);
    private final DeadPersonService deadPersonService = new DeadPersonService(deadPersonRepository);

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
}