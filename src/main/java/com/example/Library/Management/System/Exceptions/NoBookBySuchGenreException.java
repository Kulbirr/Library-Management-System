package com.example.Library.Management.System.Exceptions;

public class NoBookBySuchGenreException extends Exception {
    public NoBookBySuchGenreException(String message) {
        super(message);
    }
}
