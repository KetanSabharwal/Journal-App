package com.K10Studios.journalApp.controller;

import com.K10Studios.journalApp.entity.JournalEntry;
import com.K10Studios.journalApp.entity.User;
import com.K10Studios.journalApp.service.JournalEntryService;
import com.K10Studios.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){

        User userInDB = userService.findByUserName(user.getUserName());

        if(userInDB!=null)
        {
            user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            userService.saveEntry(userInDB);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
