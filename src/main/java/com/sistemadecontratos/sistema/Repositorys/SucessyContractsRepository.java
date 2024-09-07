package com.sistemadecontratos.sistema.Repositorys;

import com.sistemadecontratos.sistema.Models.SucessyContracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucessyContractsRepository extends JpaRepository<SucessyContracts, Long> {
}
