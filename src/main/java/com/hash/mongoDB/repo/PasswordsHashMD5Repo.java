package com.hash.mongoDB.repo;

import com.hash.mongoDB.model.PasswordsHashMD5Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordsHashMD5Repo extends MongoRepository<PasswordsHashMD5Entity, Long> {
}
