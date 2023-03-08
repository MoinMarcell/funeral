package com.github.moinmarcell.backend.repository;

import com.github.moinmarcell.backend.model.DeadPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeadPersonRepository extends MongoRepository<DeadPerson, String> {
}
