package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Entities.LibraryCard;
import com.example.Library.Management.System.Entities.Transactions;
import com.example.Library.Management.System.Enum.CardStatus;
import com.example.Library.Management.System.Enum.TransactionStatus;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Repository.CardRepository;
import com.example.Library.Management.System.Repository.TransactionRepository;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    public String issueBook(Book book) throws Exception{
        int bookId=book.getBookId();
        int cardId=book.getCard().getCardNo();

        Book book1=bookRepository.findById(bookId).get();
        LibraryCard card=cardRepository.findById(cardId).get();

        Transactions transactions = new Transactions();
        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setIssueOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);

        if(book==null|| book.isAvailable()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not Available");
        }
        if(card==null||card.getCardStatus()!= CardStatus.Active){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("card is not valid");
        }
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);


        List<Transactions> listOfTransactionsForBook=book.getTransactionsList();
        listOfTransactionsForBook.add(transactions);
        book.setTransactionsList(listOfTransactionsForBook);

        List<Book> issuedBooksForCard=card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        List<Transactions> listOfTransactionsForCard=card.getTransactionsList();
        listOfTransactionsForCard.add(transactions);
        card.setTransactionsList(listOfTransactionsForCard);

        cardRepository.save(card);
        return "Book issued successfully";
    }
}
