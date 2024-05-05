package com.careerrbear.CareerBear.user.service;

import com.careerrbear.CareerBear.exceptions.userExceptions.LoginException;
import com.careerrbear.CareerBear.exceptions.userExceptions.SignUpException;
import com.careerrbear.CareerBear.user.model.Role;
import com.careerrbear.CareerBear.user.model.UserAccount;
import com.careerrbear.CareerBear.user.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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
        userData.setEmail(userData.getEmail().toLowerCase());

        Optional<UserAccount> usingEmail = userAccountRepository.getUserAccountByEmail(userData.getEmail());

        if (usingEmail.isPresent()) {
            throw new SignUpException("email is already associated with active account");
        }

        return userAccountRepository.save(userData);
    }

    public boolean deleteUserAccount(Long userAccountId) {
        userAccountRepository.deleteById(userAccountId);
        return true;
    }

    public boolean deleteAllUserAccounts() {
        userAccountRepository.deleteAll();
        return true;
    }

    public UserAccount authenticateUser(String email, String password) {
        Optional<UserAccount> userAccount = userAccountRepository.getUserAccountByEmail(email);
        if (userAccount.isEmpty()) {
            throw new LoginException("Email Does Not Exist");
        }
        if (userAccount.isPresent() && !userAccount.get().getPassword().equals(password)) {
            throw new LoginException("Password is incorrect");
        }
        return userAccount.get();
    }


}