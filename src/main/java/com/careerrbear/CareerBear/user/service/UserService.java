package com.careerrbear.CareerBear.user.service;

import com.careerrbear.CareerBear.user.model.Role;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    UserAccountRepository userAccountRepository;

    public UserService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    public UserAccount saveUserData(UserAccount userData) {
        userData.setJoinDate(LocalDate.now());
        userData.setNewAccount(true);
        userData.setAccountRole(Role.USER);
        return userAccountRepository.save(userData);
    }

}