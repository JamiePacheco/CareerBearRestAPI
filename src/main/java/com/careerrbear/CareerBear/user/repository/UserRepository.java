package com.careerrbear.CareerBear.user.repository;

import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
