package com.codeclan.example.FilesManager.repositories;

import com.codeclan.example.FilesManager.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
