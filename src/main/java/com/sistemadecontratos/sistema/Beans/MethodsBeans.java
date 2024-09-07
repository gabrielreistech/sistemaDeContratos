package com.sistemadecontratos.sistema.Beans;

import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Dtos.SucessyContractsDto;
import com.sistemadecontratos.sistema.Models.ContractsInAgreement;
import com.sistemadecontratos.sistema.Models.CurrentContracts;
import com.sistemadecontratos.sistema.Models.SucessyContracts;
import com.sistemadecontratos.sistema.Repositorys.ContractsInAgreementRepository;
import com.sistemadecontratos.sistema.Repositorys.CurrentContractsRepository;
import com.sistemadecontratos.sistema.Repositorys.SucessyContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MethodsBeans {

    @Autowired
    CurrentContractsRepository currentContractsRepository;

    @Autowired
    ContractsInAgreementRepository contractsInAgreementRepository;

    @Autowired
    SucessyContractsRepository sucessyContractsRepository;


    public CurrentContracts insertContractsInCurrentContracts(ContractsInAgreement contractsInAgreement){
        CurrentContracts currentContracts = new CurrentContracts(contractsInAgreement);
        CurrentContracts currentContractsSave = this.currentContractsRepository.save(currentContracts);
        this.contractsInAgreementRepository.deleteById(contractsInAgreement.getId());
        return currentContractsSave;
    }

    public SucessyContracts insertContractsInSucessyContracts(CurrentContracts currentContracts){
        SucessyContracts sucessyContracts = new SucessyContracts(currentContracts);
        SucessyContracts sucessyContractsSave = this.sucessyContractsRepository.save(sucessyContracts);
        this.currentContractsRepository.deleteById(currentContracts.getId());
        return sucessyContracts;
    }

}
