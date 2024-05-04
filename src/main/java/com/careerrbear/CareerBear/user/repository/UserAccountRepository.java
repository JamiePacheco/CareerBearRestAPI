package com.careerrbear.CareerBear.user.repository;

import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
