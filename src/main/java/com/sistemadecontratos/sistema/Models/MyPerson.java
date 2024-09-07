package com.sistemadecontratos.sistema.Models;

import com.sistemadecontratos.sistema.Dtos.MyPersonDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class MyPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name =  "Nome")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Senha")
    private String password;

    public MyPerson(){}

    public MyPerson(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MyPerson(MyPersonDto myPersonDto){
        name = myPersonDto.getName();
        email = myPersonDto.getEmail();
        password = myPersonDto.getPassword();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPerson myPerson = (MyPerson) o;
        return Objects.equals(id, myPerson.id) && Objects.equals(name, myPerson.name) && Objects.equals(email, myPerson.email) && Objects.equals(password, myPerson.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }
}
