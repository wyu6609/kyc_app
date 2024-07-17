package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.VerificationStatus;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/{id}/documents")
    public ResponseEntity<String> uploadDocuments(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        // Save the file to the server or cloud storage
        return ResponseEntity.ok("Document uploaded successfully");
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<User> verifyUser(@PathVariable Long id, @RequestParam VerificationStatus status) {
        User updatedUser = userService.updateVerificationStatus(id, status);
        return ResponseEntity.ok(updatedUser);
    }
}
