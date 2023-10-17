package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "library_Card")
public class LibraryCard {

    @Id
    private String cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
}
