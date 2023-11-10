package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}
