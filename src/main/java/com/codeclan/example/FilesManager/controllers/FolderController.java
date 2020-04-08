package com.codeclan.example.FilesManager.controllers;

import com.codeclan.example.FilesManager.models.Folder;
import com.codeclan.example.FilesManager.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController{

    @Autowired
    private FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity getAllFolders(){
        List<Folder> foundFolders = folderRepository.findAll();
        return new ResponseEntity<>(foundFolders, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postPirate(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }


    }


