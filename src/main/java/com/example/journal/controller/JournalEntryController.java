package com.example.journal.controller;

import com.example.journal.Entities.Journal;
import com.example.journal.Entities.User;
import com.example.journal.services.JournalEntryService;
import com.example.journal.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{username}")
    public ResponseEntity<List<Journal>> getallbyusername(@PathVariable("username") String username){
        User dbuser = userService.findbyusername(username);
        if(dbuser==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Journal> list = new ArrayList<>();

        for(Journal journal: dbuser.getJournalLists()){
            list.add(journalEntryService.getbyid(journal.getId()));
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }


//    saving
@PostMapping("/{username}")
public ResponseEntity<Journal> postjournal(@RequestBody Journal myjournal,@PathVariable("username") String username){
    try{
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
    @DeleteMapping("{username}/id/{id}")
    public boolean deleteid(@PathVariable("id") ObjectId id,@PathVariable("username") String username){
        User dbuser = userService.findbyusername(username);
        dbuser.getJournalLists().removeIf(x -> x.getId().equals(id));
        User newuser = userService.saveuser(dbuser);
        return journalEntryService.deleteentry(id);

    }

    //    updating
    @PutMapping("/{id}")
    public Journal putid(@PathVariable("id") ObjectId id,@RequestBody Journal myjournal){
        return journalEntryService.updateentry(id,myjournal);
    }

}
