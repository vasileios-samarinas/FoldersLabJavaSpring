package com.codeclan.example.FilesManager.repositories;

import com.codeclan.example.FilesManager.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
