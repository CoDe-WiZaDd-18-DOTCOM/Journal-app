package com.example.journal.sevicestest;


import com.example.journal.controller.UserController;
import com.example.journal.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @ParameterizedTest
    @CsvSource({
            "jass,False",
            "user2,False"
    })
    public void deleteusertest(String name,String expected) {
        assertEquals(userService.deleteuser(name),expected);
    }
}
