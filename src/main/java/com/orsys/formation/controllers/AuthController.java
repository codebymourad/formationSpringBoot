package com.orsys.formation.controllers;

import com.orsys.formation.models.User;
import com.orsys.formation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateUser(@RequestParam String username) {
        try {
            System.out.println(username);
            return new ResponseEntity<User>(userService.generateApikey(username), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
