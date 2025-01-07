package com.example.journal.repository;

import com.example.journal.Entities.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
public interface JournalEntryRepository extends MongoRepository<Journal, ObjectId> {

}
