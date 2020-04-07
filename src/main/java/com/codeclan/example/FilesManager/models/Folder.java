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

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;


    @ManyToMany
    @JoinTable(
            name = "folders_files",
            joinColumns = {
                    @JoinColumn(
                            name = "folder_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "file_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<File>files;


    public Folder(String title, User user) {
        this.title = title;
        this.user = user;
        this.files=new ArrayList<>();
    }

    public Folder(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
