package com.example.journal.Entities;

import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

//@Data
//@NoArgsConstructor  // most important don't forget you don't even know what causes error , it is included cause @Data doesn't include it.
@Document(collection = "users")
public class User {
    @Id // primary key
    private ObjectId id;

    @Indexed(unique = true) // unique for every user.
    @NonNull
    private String userName;

    @NonNull  // should not be null (from Lombok).
    private String password;

    private String email;
    private Boolean sentimentalAnalysis;

    @DBRef // reference to journal_entries
    private List<Journal> journalLists = new ArrayList<>();

    private List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public @NonNull String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public List<Journal> getJournalLists() {
        return journalLists;
    }

    public void setJournalLists(List<Journal> journalLists) {
        this.journalLists = journalLists;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSentimentalAnalysis() {
        return sentimentalAnalysis;
    }

    public void setSentimentalAnalysis(Boolean sentimentalAnalysis) {
        this.sentimentalAnalysis = sentimentalAnalysis;
    }
}
