package com.codeclan.example.FilesManager.controllers;

import com.codeclan.example.FilesManager.models.File;
import com.codeclan.example.FilesManager.models.Folder;
import com.codeclan.example.FilesManager.repositories.FileRepository;
import com.codeclan.example.FilesManager.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.Files;
import java.util.List;

public class FileController {


    @Autowired
    private FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity getAllFiles(){
        List<File> foundFiles = fileRepository.findAll();
        return new ResponseEntity<>(foundFiles, HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
