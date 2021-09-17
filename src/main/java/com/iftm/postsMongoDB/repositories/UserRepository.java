package com.iftm.postsMongoDB.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iftm.postsMongoDB.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
