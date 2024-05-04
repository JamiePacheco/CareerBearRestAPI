package com.careerrbear.CareerBear.user.repository;

import com.careerrbear.CareerBear.user.model.UserAccount;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserAccount, Long> {
}
