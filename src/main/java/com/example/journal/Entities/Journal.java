package com.example.journal.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
@Document(collection = "journal_entries")
public class Journal {
    @Id
    private ObjectId id;

    private String name;
    private double cpi;
    private LocalDateTime ld;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCpi() {
        return cpi;
    }

    public void setCpi(double cpi) {
        this.cpi = cpi;
    }

    public LocalDateTime getLd() {
        return ld;
    }

    public void setLd(LocalDateTime ld) {
        this.ld = ld;
    }



}
