package com.example.journal.controller;

import com.example.journal.Entities.User;
import com.example.journal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private AppCache appCache;
    @GetMapping("/all-users")
    public ResponseEntity<?> getallusers(){
        return new ResponseEntity<>(userService.getall(), HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createuser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveadmin(user),HttpStatus.OK);
    }

    @GetMapping("/clear-cache")
    public void clearCache(){
//        appCache.appCache.clear();
        appCache.init();
    }


    @GetMapping("/SA")
    public ResponseEntity<List<User>> getBySA(){
        List<User> list = userService.getUsersWithSA();
        if(list.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
