package com.codeclan.example.FilesManager.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<Folder>folders;

    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
