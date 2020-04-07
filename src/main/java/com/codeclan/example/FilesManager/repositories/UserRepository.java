package com.codeclan.example.FilesManager.repositories;

import com.codeclan.example.FilesManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
