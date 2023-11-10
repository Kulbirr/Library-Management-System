package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enum.CardStatus;
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
@Table(name = "library_Card")
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private String nameOnCard;

    @OneToOne
    @JoinColumn
    private Student student;
}

