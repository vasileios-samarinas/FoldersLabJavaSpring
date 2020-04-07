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

        fileRepository.deleteAll();
        folderRepository.deleteAll();
        userRepository.deleteAll();

        User bob = new User("Bob");
        userRepository.save(bob);

        User mike = new User("Mike");
        userRepository.save(mike);

        User harry = new User("Harry");
        userRepository.save(harry);

        Folder music = new Folder("Music",bob);
        folderRepository.save(music);

        Folder pictures = new Folder("Pictures",bob);
        folderRepository.save(pictures);

        Folder apps = new Folder("Apps",mike);
        folderRepository.save(apps);

        Folder flash = new Folder("Flash",harry);
        folderRepository.save(flash);

        Folder teams = new Folder("Teams",harry);
        folderRepository.save(teams);

        Folder balls = new Folder("Balls",bob);
        folderRepository.save(balls);

        File names= new File("names","ptt",5);
        fileRepository.save(names);

        File surnames= new File("surnames","java",10);
        fileRepository.save(surnames);

        File list= new File("list","ptt",90);
        fileRepository.save(list);

        File recipes= new File("recipes","txt",2);
        fileRepository.save(recipes);

        File flags= new File("flags","java",100);
        fileRepository.save(flags);

        balls.addFile(names);
        balls.addFile(surnames);
        folderRepository.save(balls);

        surnames.addFolder(teams);
        fileRepository.save(surnames);

        list.addFolder(flash);
        list.addFolder(apps);
        fileRepository.save(list);

        recipes.addFolder(apps);
        fileRepository.save(recipes);

        music.addFile(flags);
        music.addFile(recipes);
        folderRepository.save(music);

        surnames.addFolder(flash);
        fileRepository.save(surnames);

        }
    }
