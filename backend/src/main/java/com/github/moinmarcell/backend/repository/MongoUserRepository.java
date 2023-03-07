package com.github.moinmarcell.backend.repository;

import com.github.moinmarcell.backend.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<MongoUser, String> {

    Optional<MongoUser> findMongoUserByEmail(String email);

}
