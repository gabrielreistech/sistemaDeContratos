package com.sistemadecontratos.sistema.Dtos;

import com.sistemadecontratos.sistema.Models.MyPerson;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MyPersonDto {

    private Long id;

    @NotBlank(message = "É necessário informar o seu nome.")
    private String name;

    @Email(message = "O email fornecido é inválido.")
    @NotBlank(message = "É necessário informar o seu email.")
    private String email;

    @NotBlank(message = "É necessário informa sua senha.")
    @Size(min = 6, max = 6, message = "A senha deve conter 6 dígitos.")
    private String password;

    public MyPersonDto(){}

    public MyPersonDto(MyPerson myPerson){
        id = myPerson.getId();
        name = myPerson.getName();
        email = myPerson.getEmail();
        password = myPerson.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
