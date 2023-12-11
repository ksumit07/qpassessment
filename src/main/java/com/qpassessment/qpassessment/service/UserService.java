package com.qpassessment.qpassessment.service;

import com.qpassessment.qpassessment.model.User;
import com.qpassessment.qpassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isUserAdmin(long userId) {
        Optional<User> userOptional = userRepository.findById(Long.valueOf(userId));
        return !userOptional.isEmpty() && userOptional.get().getRole().equals("admin");
    }
}
