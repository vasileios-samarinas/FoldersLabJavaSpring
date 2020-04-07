package com.codeclan.example.FilesManager.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    private List<File>files;

    private User user;


    public Folder(String title, User user) {
        this.title = title;
        this.user = user;
        this.files=new ArrayList<>();
    }

    public Folder(){}


}
