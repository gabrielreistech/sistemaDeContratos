package com.sistemadecontratos.sistema.Repositorys;

import com.sistemadecontratos.sistema.Models.CurrentContracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentContractsRepository extends JpaRepository<CurrentContracts, Long> {
}
