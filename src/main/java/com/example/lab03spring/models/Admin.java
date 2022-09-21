package com.example.lab03spring.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Admin {

    @NotEmpty(message = "Le nom d'utilisateur ne peut pas etre vide")
    @Pattern(regexp = "^(admin)$", message = "Le nom d'utilisateur est incorrect")
    private String username;
    @NotEmpty(message = "Le mot de passe ne peut pas etre vide")
    @Pattern(regexp = "^(password)$", message = "Le mot de passe est incorrect")
    private String password;

    public Admin() {
    }
}
