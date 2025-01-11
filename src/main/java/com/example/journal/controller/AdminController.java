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

    @GetMapping("/all-users")
    public ResponseEntity<?> getallusers(){
        return new ResponseEntity<>(userService.getall(), HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createuser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveadmin(user),HttpStatus.OK);
    }
}
