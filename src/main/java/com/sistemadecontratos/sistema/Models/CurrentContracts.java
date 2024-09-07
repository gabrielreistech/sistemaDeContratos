package com.sistemadecontratos.sistema.Models;

import com.sistemadecontratos.sistema.Models.Abstract.Contract;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Contratos_Atuais")
public class CurrentContracts extends Contract {

    public CurrentContracts(){}

    public CurrentContracts(ContractsInAgreement contractsInAgreement) {
        this.setId(contractsInAgreement.getId());
        this.setName(contractsInAgreement.getName());
        this.setDescription(contractsInAgreement.getDescription());
        this.setClient(contractsInAgreement.getClient());
        this.setPrice(contractsInAgreement.getPrice());
        this.setContractDay(contractsInAgreement.getContractDay());
        this.setContractEnd(contractsInAgreement.getContractEnd());
    }
}
