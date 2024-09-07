package com.sistemadecontratos.sistema.Models;

import com.sistemadecontratos.sistema.Models.Abstract.Contract;
import jakarta.persistence.*;

@Entity
@Table(name = "Contratos_De_Sucesso")
public class SucessyContracts extends Contract {

    public SucessyContracts(){}

    public SucessyContracts(CurrentContracts currentContracts){
        this.setId(currentContracts.getId());
        this.setName(currentContracts.getName());
        this.setDescription(currentContracts.getDescription());
        this.setPrice(currentContracts.getPrice());
        this.setClient(currentContracts.getClient());
        this.setContractDay(currentContracts.getContractDay());
        this.setContractEnd(currentContracts.getContractEnd());
    }

}
