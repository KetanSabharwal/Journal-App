package com.K10Studios.journalApp.service;

import com.K10Studios.journalApp.entity.JournalEntry;
import com.K10Studios.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;

    public List<JournalEntry> getJournals()
    {
        return journalEntryRepository.findAll();
    }

    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);
    }

    public ResponseEntity<?> getJournalById(ObjectId myId){

        Optional<JournalEntry> journalEntry = journalEntryRepository.findById(myId);
        if(journalEntry.isPresent())
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public boolean deleteJournalById(ObjectId myId){
        journalEntryRepository.deleteById(myId);
        return true;
    }

    public ResponseEntity<?> updateJournal(ObjectId myId , JournalEntry newEntry){

        JournalEntry journalEntryOld = journalEntryRepository.findById(myId).orElse(null);

        if(journalEntryOld !=null){
            journalEntryOld.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle(): journalEntryOld.getTitle());
            journalEntryOld.setContent(newEntry.getContent()!=null && !newEntry.getContent().isEmpty() ? newEntry.getContent(): journalEntryOld.getTitle());
            journalEntryRepository.save(journalEntryOld);
            return new ResponseEntity<>(myId,HttpStatus.OK);
        }

        return new ResponseEntity<>(myId,HttpStatus.NOT_FOUND);
    }


}
