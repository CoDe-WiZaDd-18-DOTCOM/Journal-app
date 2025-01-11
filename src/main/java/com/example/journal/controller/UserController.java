package com.example.journal.controller;

import com.example.journal.Entities.User;
import com.example.journal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    //    get

    @GetMapping("/{username}")
    public ResponseEntity<User> getbyusername(@PathVariable("username") String username){
        User user = userService.findbyusername(username);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //    save
//    @PostMapping
//    public ResponseEntity<User> saveuser(@RequestBody User user){
//        User newuser = userService.saveuser(user);
//        if(newuser==null) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
//        return new ResponseEntity<>(newuser,HttpStatus.OK);
//    }

    //    delete
    @DeleteMapping
    public ResponseEntity<String> deleteuser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String state = userService.deleteuser(username);
        if(state.equals("True")) return new ResponseEntity<>("True",HttpStatus.OK);
        return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
    }

    //    update
    @PutMapping
    public ResponseEntity<User> updateuser(@RequestBody User newuser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
        User user = userService.updateuser(username,newuser);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
