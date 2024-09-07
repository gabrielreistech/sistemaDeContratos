package com.sistemadecontratos.sistema.Repositorys;

import com.sistemadecontratos.sistema.Models.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyPersonRepository extends JpaRepository<MyPerson, Long> {

    Optional<MyPerson>findByName(String name);
}
