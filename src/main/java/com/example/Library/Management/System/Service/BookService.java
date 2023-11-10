package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entities.Author;
import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Enum.Genre;
import com.example.Library.Management.System.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.System.Exceptions.NoBookBySuchGenreException;
import com.example.Library.Management.System.Repository.AuthorRepository;
import com.example.Library.Management.System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    public String addBook(Book book, Integer authorId) throws Exception {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Author Id is invalid");
        }
        Author author = authorOptional.get();

//        Setting author bcoz it cant be
        book.setAuthor(author);
//Since it's a bidirectional mapping i am also adding books in the author books list
        author.getBooks().add(book);

//        I will save only author because there is bidirectional mapping between author and book, and author is the parent
//        saving author bcoz i made modification to author here(modified author books list)
        authorRepository.save(author);

        return "Book has been added Successfully!";
    }


    public List<String> getBookByGenre(Genre genre) throws Exception{
        List<Book> bookList = bookRepository.findBooksByGenre(genre);
        List<String> booksByGenre = new ArrayList<>();

        if(bookList.isEmpty()){
            throw new NoBookBySuchGenreException("There is no book by this genre.");
        }

        for(Book book : bookList){
            booksByGenre.add(book.getBookName());
        }
        return booksByGenre;
    }
}