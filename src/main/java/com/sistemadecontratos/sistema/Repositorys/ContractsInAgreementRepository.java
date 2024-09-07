package com.sistemadecontratos.sistema.Repositorys;

import com.sistemadecontratos.sistema.Models.ContractsInAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsInAgreementRepository extends JpaRepository<ContractsInAgreement, Long> {
}
