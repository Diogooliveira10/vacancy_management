package br.com.diogooliveira.vacancy_management.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User already exists");
    }
}
