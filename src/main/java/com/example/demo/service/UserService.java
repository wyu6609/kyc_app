package com.example.demo.service;

import com.example.demo.model.VerificationStatus;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        user.setPassword("password");
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateVerificationStatus(Long userId, VerificationStatus status) {
        User user = getUserById(userId);
        if (user != null) {
            user.setVerificationStatus(status);
            return userRepository.save(user);
        }
        return null;
    }
}
