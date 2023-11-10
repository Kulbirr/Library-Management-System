package com.example.Library.Management.System.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int transactionId;

    private Date issueDate;

    private int fine;

    private Date returnDate;

}
