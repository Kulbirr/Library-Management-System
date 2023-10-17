package com.example.Library.Management.System.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String studentId;

    private String Name;

    private Integer age;

    @Column(name = "contactInfo", unique = true, nullable = false)
    private String contact;

    private String emailId;
}
