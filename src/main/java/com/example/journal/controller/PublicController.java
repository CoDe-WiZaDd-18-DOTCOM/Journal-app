package com.example.journal.controller;

import com.example.journal.Entities.User;
import com.example.journal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserRepository userRepository;


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PostMapping("/save-user")
    public User saveEntry(@RequestBody User us){
        if(userRepository.findByUserName(us.getUserName()) == null) {
            us.setPassword(passwordEncoder.encode(us.getPassword()));
            List<String> li = us.getRoles();
            li.add("USER");
            us.setRoles(li);
            userRepository.save(us);
            return us;
        }
        return null;
    }
}
