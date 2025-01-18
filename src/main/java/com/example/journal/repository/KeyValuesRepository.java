package com.example.journal.repository;

import com.example.journal.Entities.KeyValues;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValuesRepository extends MongoRepository<KeyValues, ObjectId> {

}
