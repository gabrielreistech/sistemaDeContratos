package com.sistemadecontratos.sistema.Repositorys;

import com.sistemadecontratos.sistema.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
