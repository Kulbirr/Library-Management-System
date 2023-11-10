package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entities.Author;
import com.example.Library.Management.System.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String result = authorService.addAuthor(author);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    @GetMapping("/findAllAuthorNames")
    public List<String> getAllAuthorNames(){
        return authorService.getAllAuthorNames();
    }

    @GetMapping("/findAuthorById")
    public ResponseEntity getAuthorById(@RequestParam("q") Integer authorId){
           try{
               Author author = authorService.getAuthorById(authorId);
               return new ResponseEntity(author, HttpStatus.OK);
           }
           catch(Exception e){
               return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getBooksNameList")
    public ResponseEntity getBooks(@RequestParam("authorId") Integer authorId){
        try{
            List<String> books = authorService.getBooks(authorId);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("updateAuthorDetails")
    public ResponseEntity updateAuthor(@RequestBody Author updatedAuthor, @RequestParam("Id") Integer authorId){
        try{
            String result = authorService.updateAuthor(updatedAuthor, authorId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (AuthorNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteAuthor{Id}")
    public ResponseEntity deleteAuthor(@PathVariable("Id") Integer authorId){
        try{
            String result = authorService.deleteAuthor(authorId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (AuthorNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
