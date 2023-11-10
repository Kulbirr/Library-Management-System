package com.example.Library.Management.System.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //this means its a structure that will be reflected in database
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;

    private Integer age;

    @Column(name = "contactInfo", unique = true, nullable = false)
    private String contact;

    private String emailId;

//
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
