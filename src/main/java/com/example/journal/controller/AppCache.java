package com.example.journal.controller;

import com.example.journal.Entities.KeyValues;
import com.example.journal.repository.KeyValuesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    public Map<String,String> appCache;

    @Autowired
    private KeyValuesRepository keyValuesRepository;

    @PostConstruct
    public void init(){
        appCache = new HashMap<>();
        List<KeyValues> list = keyValuesRepository.findAll();
        for(KeyValues li : list){
            appCache.put(li.getKey(), li.getValue());
        }
    }
}
