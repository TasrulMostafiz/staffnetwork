package com.example.staffnetwork.database.repository;

import com.example.staffnetwork.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByIdEquals(UUID id);

}
