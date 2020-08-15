package com.example.messenger.messenger.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class Post extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Enter content, content not null")
    @Size(max = 100, min = 2, message = "Title not valid")
    @Column(unique = true)
    private String title;

    @NotNull(message = "Enter content, content not null ")
    @Size(max = 250, min = 3, message = "description not valid")
    private String description;

    @NotNull(message = "Enter content, content not null")
    @Lob ////??????
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

    @PrePersist
    public void prePersist() {
        System.out.println("PrePersist");

    }

    @PostLoad
    public void postLoad() {
        System.out.println("PostLoad");

    }


}
