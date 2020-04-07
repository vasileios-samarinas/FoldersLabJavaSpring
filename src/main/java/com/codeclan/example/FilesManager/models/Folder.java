package com.codeclan.example.FilesManager.models;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    private String title;
    private List<File>files;
    private User user;


    public Folder(String title, User user) {
        this.title = title;
        this.user = user;
        this.files=new ArrayList<>();
    }
}
