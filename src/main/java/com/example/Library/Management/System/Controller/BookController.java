package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Enum.Genre;
import com.example.Library.Management.System.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.System.Service.AuthorService;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("add")
    private ResponseEntity addBook(@RequestBody Book book, @RequestParam("authorId") Integer authorId) {
        try {
            String response = bookService.addBook(book, authorId);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getBookByGenre")
    private ResponseEntity getBookByGenre(@RequestParam("genre")Genre genre){
        try{
            List<String> books = bookService.getBookByGenre(genre);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
