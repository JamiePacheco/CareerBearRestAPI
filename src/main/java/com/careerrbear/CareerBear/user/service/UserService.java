package com.careerrbear.CareerBear.user.service;

import com.careerrbear.CareerBear.user.model.Role;
import com.careerrbear.CareerBear.user.model.User;
import com.careerrbear.CareerBear.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUserData(User userData) {
        userData.setJoinDate(LocalDate.now());
        userData.setNewAccount(true);
        userData.setAccountRole(Role.USER);
        return userRepository.save(userData);
    }

}