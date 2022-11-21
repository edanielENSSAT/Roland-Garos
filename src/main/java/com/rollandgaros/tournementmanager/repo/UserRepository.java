package com.rollandgaros.tournementmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rollandgaros.tournementmanager.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
