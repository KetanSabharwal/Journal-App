package com.K10Studios.journalApp.service;

import com.K10Studios.journalApp.entity.JournalEntry;
import com.K10Studios.journalApp.entity.User;
import com.K10Studios.journalApp.repository.JournalEntryRepository;
import com.K10Studios.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public void saveEntry(User user) { userRepository.save(user); }

    public Optional<User> findById(ObjectId myId){ return userRepository.findById(myId); }

    public void deleteById( ObjectId myId){ userRepository.deleteById(myId); }

    public User findByUserName(String userName){
        User user = userRepository.findByUserName(userName);
        return user;
    }
}

