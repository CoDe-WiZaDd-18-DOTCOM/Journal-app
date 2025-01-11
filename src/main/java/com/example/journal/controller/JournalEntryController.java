package com.example.journal.controller;

import com.example.journal.Entities.Journal;
import com.example.journal.Entities.User;
import com.example.journal.services.JournalEntryService;
import com.example.journal.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private  JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;


    //fetching
    @GetMapping
    public List<Journal> getall(){
        return journalEntryService.getallentries();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Journal> getbyid(@PathVariable("id") ObjectId id){
        Journal js= journalEntryService.getbyid(id);
        if(js==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(js,HttpStatus.OK);
    }

    @GetMapping("/my-journals")
    public ResponseEntity<List<Journal>> getallbyusername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User dbuser = userService.findbyusername(username);
        if(dbuser==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Journal> list = new ArrayList<>();

        for(Journal journal: dbuser.getJournalLists()){
            list.add(journalEntryService.getbyid(journal.getId()));
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    //    saving
    @PostMapping("/my-journals")
    public ResponseEntity<Journal> postjournal(@RequestBody Journal myjournal){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Journal js = journalEntryService.setentry(myjournal);
            User dbuser = userService.findbyusername(username);
            dbuser.getJournalLists().add(js);
            userService.saveuserjournalentries(dbuser);
            return new ResponseEntity<>(js,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

//    delete
    @DeleteMapping("/my-journals/id/{id}")
    public ResponseEntity<Boolean> deleteid(@PathVariable("id") ObjectId id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User dbuser = userService.findbyusername(username);
        Boolean check=false;
        if(dbuser.getJournalLists().size()==0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        for(Journal journal: dbuser.getJournalLists()) {
            if(journal.getId().equals(id)) {
                check=true;
                break;
            }
        }

        if(!check) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(journalEntryService.deleteentry(id,dbuser),HttpStatus.OK);

    }

    //    updating
    @PutMapping("/my-journals/id/{id}")
    public ResponseEntity<Journal> putid(@PathVariable("id") ObjectId id,@RequestBody Journal myjournal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User dbuser = userService.findbyusername(username);
        Boolean check=false;
        if(dbuser.getJournalLists().size()==0) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        for(Journal journal: dbuser.getJournalLists()) {
            if(journal.getId().equals(id)) {
                check=true;
                break;
            }
        }

        if(!check) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(journalEntryService.updateentry(id,myjournal),HttpStatus.OK);

    }
}
