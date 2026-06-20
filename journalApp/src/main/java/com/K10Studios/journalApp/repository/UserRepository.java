package com.K10Studios.journalApp.repository;

import com.K10Studios.journalApp.entity.JournalEntry;
import com.K10Studios.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

     User findByUserName(String username);
}
