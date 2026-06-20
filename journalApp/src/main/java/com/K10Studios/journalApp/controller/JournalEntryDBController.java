package com.K10Studios.journalApp.controller;

import com.K10Studios.journalApp.entity.JournalEntry;
import com.K10Studios.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryDBController {

    @Autowired
    public JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getJournalList()
    {
        return journalEntryService.getJournals();
    }

    @PostMapping
    public ResponseEntity<?> postJournal(@RequestBody JournalEntry journalEntry)
    {
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(journalEntry);
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable ObjectId myId)
    {
        return journalEntryService.getJournalById(myId);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId myId)
    {
        journalEntryService.deleteJournalById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateJournal(@PathVariable ObjectId myId , @RequestBody JournalEntry journalEntry)
    {
        return journalEntryService.updateJournal(myId,journalEntry);

    }
}
