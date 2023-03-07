package com.github.moinmarcell.backend.repository;

import com.github.moinmarcell.backend.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, String> {

    Optional<MongoUser> findMongoUserByEmail(String email);

}
