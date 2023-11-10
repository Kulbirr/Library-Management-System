package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entities.Author;
import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;


    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author saved successfully.";
    }

    public List<String> getAllAuthorNames() {
        List<Author> allAuthors = authorRepository.findAll();

        List<String> authorNames = new ArrayList<>();

        for (Author author : allAuthors) {
            authorNames.add(author.getAuthorName());
        }
        return authorNames;
    }

    public Author getAuthorById(Integer authorId) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalAuthor.isEmpty()) {
            throw new AuthorNotFoundException("No author with the given authorId : " + authorId);
        }
        Author author = optionalAuthor.get();
        return author;
    }

    public List<String> getBooks(Integer authorId) throws Exception {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new AuthorNotFoundException("No author with the given authorId : " + authorId);
        }

        Author author = authorOptional.get();

        List<Book> booksList = author.getBooks();
        if (booksList.isEmpty()) {
            throw new Exception("There are no Books for given authorId");
        }

        List<String> booksName = new ArrayList<>();
        for (Book book : booksList) {
            booksName.add(book.getBookName());
        }
        return booksName;
    }

    public String updateAuthor(Author updatedAuthor, Integer authorId) throws AuthorNotFoundException{
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("No author with the given authorId : " + authorId);
        }

        Author author = optionalAuthor.get();

//        updating Valuee;
        author.setBooks(updatedAuthor.getBooks());
        author.setAuthorName(updatedAuthor.getAuthorName());
        author.setAge(updatedAuthor.getAge());
        author.setRating(updatedAuthor.getRating());

        authorRepository.save(author);
        return "Author with authorId : " + authorId +" has been updated successfully.";

    }

    public String deleteAuthor(Integer authorId) throws AuthorNotFoundException{
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("No author with the given authorId : " + authorId);
        }
        Author author = optionalAuthor.get();

        authorRepository.delete(author);

        return "Author with authorId : " + authorId +" has been deleted successfully.";
    }
}
