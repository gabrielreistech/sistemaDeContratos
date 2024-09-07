package com.sistemadecontratos.sistema.Services;

import com.sistemadecontratos.sistema.Beans.MethodsBeans;
import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Dtos.CurrentContractsDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Models.ContractsInAgreement;
import com.sistemadecontratos.sistema.Models.CurrentContracts;
import com.sistemadecontratos.sistema.Repositorys.ContractsInAgreementRepository;
import com.sistemadecontratos.sistema.Repositorys.CurrentContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrentContractsService {

    @Autowired
    CurrentContractsRepository currentContractsRepository;

    @Autowired
    ContractsInAgreementRepository contractsInAgreementRepository;

    @Autowired
    MethodsBeans methodsBeans;

    @Transactional
    public CurrentContractsDtoRespostaObjeto insertContract(Long id){

        ContractsInAgreement contractsInAgreement = this.contractsInAgreementRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Contrato de acordo não localizado para ser adicionado nos contratos atuais."));

         CurrentContracts currentContracts = methodsBeans.insertContractsInCurrentContracts(contractsInAgreement);

         return new CurrentContractsDtoRespostaObjeto(currentContracts);
    }

    public Page<CurrentContractsDto> findAll(Pageable pageable){
        Page<CurrentContracts> currentContracts = this.currentContractsRepository.findAll(pageable);
        return currentContracts.map(CurrentContractsDto::new);
    }
}
