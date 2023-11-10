package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table //In case we don't write any name class name is taken as table name
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    private int price;

    private int noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private double rating;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Author author;
}
