//package com.K10Studios.journalApp.controller;
//
//import com.K10Studios.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    Map<Long, JournalEntry> journalEntryMap = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getJournalList()
//    {
//        return new ArrayList<>(journalEntryMap.values());
//    }
//
//    @PostMapping
//    public boolean postJournal(@RequestBody JournalEntry journalEntry)
//    {
//        journalEntryMap.put(journalEntry.getId(), journalEntry );
//        return true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId)
//    {
//        return journalEntryMap.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public boolean deleteJournal(@PathVariable Long myId)
//    {
//        journalEntryMap.remove(myId);
//        return true;
//    }
//
//    @PutMapping("id/{myId}")
//    public boolean updateJournal(@PathVariable Long myId , @RequestBody JournalEntry journalEntry)
//    {
//        journalEntryMap.put(myId, journalEntry);
//        return true;
//    }
//}
