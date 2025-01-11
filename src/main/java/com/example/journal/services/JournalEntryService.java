package com.example.journal.services;

import com.example.journal.Entities.Journal;
import com.example.journal.Entities.User;
import com.example.journal.repository.JournalEntryRepository;
import com.example.journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository jen;

    @Autowired
    private UserRepository userRepository;

    //saving entries
    public Journal setentry(Journal jou){
        jou.setLd(LocalDateTime.now());
        return jen.save(jou);
    }

    //fetching
    public List<Journal> getallentries(){
        return jen.findAll();
    }

    public Journal getbyid(ObjectId id){
        return jen.findById(id).orElse(null);
    }

    //updating
    public Journal updateentry(ObjectId id,Journal newone){
        Journal oldone = getbyid(id);
        if(oldone!=null){
            if(newone.getName()!=null && !newone.getName().isEmpty()) oldone.setName(newone.getName());
            if(!Double.isNaN(newone.getCpi())) oldone.setCpi(newone.getCpi());
        }
        jen.save(oldone);
        return oldone;
    }

    //deleting
    public boolean deleteentry(ObjectId id,User dbuser){
        Optional<Journal> journal = jen.findById(id);
        if (journal.isPresent()) {
            dbuser.getJournalLists().removeIf(jou -> jou.getId().equals(id));

            jen.deleteById(id);

            userRepository.save(dbuser);

            return true;
        }
        return true;
    }
}
