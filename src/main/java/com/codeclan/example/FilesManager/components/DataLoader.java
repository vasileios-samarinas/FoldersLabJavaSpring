package com.codeclan.example.FilesManager.components;

import com.codeclan.example.FilesManager.models.File;
import com.codeclan.example.FilesManager.models.Folder;
import com.codeclan.example.FilesManager.models.User;
import com.codeclan.example.FilesManager.repositories.FileRepository;
import com.codeclan.example.FilesManager.repositories.FolderRepository;
import com.codeclan.example.FilesManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    public void run (ApplicationArguments args) throws Exception {
//
//        userRepository.deleteAll();
//        folderRepository.deleteAll();
//        fileRepository.deleteAll();



        User mike = new User("Mike");
        userRepository.save(mike);

        User harry = new User("Harry");
        userRepository.save(harry);


        Folder apps = new Folder("Apps",mike);
        folderRepository.save(apps);

        Folder flash = new Folder("Flash",harry);
        folderRepository.save(flash);


        File list= new File("list","ptt",90);
        fileRepository.save(list);

        File recipes= new File("recipes","txt",2);
        fileRepository.save(recipes);

        File flags= new File("flags","java",100);
        fileRepository.save(flags);


        list.addFolder(flash);
        list.addFolder(apps);
        fileRepository.save(list);

        recipes.addFolder(apps);
        fileRepository.save(recipes);

        apps.addFile(list);
        folderRepository.save(apps);


        }
    }
