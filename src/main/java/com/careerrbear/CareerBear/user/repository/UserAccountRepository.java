package com.careerrbear.CareerBear.user.repository;

import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> getUserAccountById(Long UserAccountId);

    Optional<UserAccount> getUserAccountByEmail(String email);
}
