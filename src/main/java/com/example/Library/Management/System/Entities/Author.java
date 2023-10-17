package com.example.Library.Management.System.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author_table")
public class Author {

    @Id
    private Integer authorId;

    private String authorName;

    private int age;

    private double rating;
}
