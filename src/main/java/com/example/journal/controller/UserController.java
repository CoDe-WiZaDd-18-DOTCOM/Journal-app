package com.example.journal.controller;

import com.example.journal.Entities.User;
import com.example.journal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //    get
    @GetMapping
    public ResponseEntity<?> getallusers(){
        return new ResponseEntity<>(userService.getall(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getbyusername(@PathVariable("username") String username){
        User user = userService.findbyusername(username);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //    save
    @PostMapping
    public ResponseEntity<User> saveuser(@RequestBody User user){
        User newuser = userService.saveuser(user);
        if(newuser==null) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
        return new ResponseEntity<>(newuser,HttpStatus.OK);
    }

    //    delete
    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteuser(@PathVariable("username") String username){
        String state = userService.deleteuser(username);
        if(state.equals("True")) return new ResponseEntity<>("True",HttpStatus.OK);
        return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
    }

    //    update
    @PutMapping("/{username}")
    public ResponseEntity<User> updateuser(@RequestBody User newuser,@PathVariable("username") String username){
        User user = userService.updateuser(username,newuser);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
