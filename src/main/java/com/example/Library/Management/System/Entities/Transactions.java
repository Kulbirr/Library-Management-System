package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionId = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    private LibraryCard card;

    @ManyToOne
    @JoinColumn
    private Book book;
}
