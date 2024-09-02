package com.sistemadecontratos.sistema.Beans;

import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Models.ModelsContracts.ContractsInAgreement;
import com.sistemadecontratos.sistema.Models.ModelsContracts.CurrentContracts;
import com.sistemadecontratos.sistema.Repositorys.ContractsInAgreementRepository;
import com.sistemadecontratos.sistema.Repositorys.CurrentContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MethodsBeans {

    @Autowired
    CurrentContractsRepository currentContractsRepository;
    @Autowired
    ContractsInAgreementRepository contractsInAgreementRepository;

    public CurrentContractsDto addContractsInCurrentContracts(ContractsInAgreement contractsInAgreement){
        CurrentContracts currentContracts = new CurrentContracts(contractsInAgreement);
        CurrentContracts currentContractsSave = this.currentContractsRepository.save(currentContracts);
        this.contractsInAgreementRepository.deleteById(contractsInAgreement.getId());
        return new CurrentContractsDto(currentContractsSave);
    }

}
