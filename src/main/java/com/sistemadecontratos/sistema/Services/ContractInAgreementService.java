package com.sistemadecontratos.sistema.Services;

import com.sistemadecontratos.sistema.Dtos.ContractsInAgreementDto;
import com.sistemadecontratos.sistema.Dtos.ContractsInAgreementDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.ModelsContracts.ContractsInAgreement;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import com.sistemadecontratos.sistema.Repositorys.ContractsInAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContractInAgreementService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ContractsInAgreementRepository contractsInAgreementRepository;

    public ContractsInAgreementDtoRespostaObjeto save(ContractsInAgreementDto contractsInAgreementDto){
        Client clientExist = this.clientRepository.findById(contractsInAgreementDto.getClient()).orElseThrow(() -> new RuntimeException("Id de cliente não localizado."));

        ContractsInAgreement contractsInAgreement = new ContractsInAgreement();
        contractsInAgreement.setContractDay(LocalDateTime.now());
        contractsInAgreement.setClient(clientExist);
        contractsInAgreement.setDescription(contractsInAgreementDto.getDescription());
        contractsInAgreement.setName(contractsInAgreementDto.getName());
        if(contractsInAgreementDto.getPrice() != null){
            contractsInAgreement.setPrice(contractsInAgreementDto.getPrice());
        }else{
            contractsInAgreement.setPrice(0.0);
        }
        contractsInAgreement.setContractDay(contractsInAgreementDto.getContractDay());
        contractsInAgreement.setContractEnd(contractsInAgreementDto.getContractEnd());

        ContractsInAgreement contractsInAgreementSave = this.contractsInAgreementRepository.save(contractsInAgreement);
        return new ContractsInAgreementDtoRespostaObjeto(contractsInAgreementSave);
    }

    public Page<ContractsInAgreementDtoRespostaObjeto> findAll(Pageable pageable){
        Page<ContractsInAgreement> page = this.contractsInAgreementRepository.findAll(pageable);
        return page.map(ContractsInAgreementDtoRespostaObjeto::new);
    }

    public void deleteById(Long id){
        ContractsInAgreement contract = this.contractsInAgreementRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrato em acordo não foi localizado para ser deletado."));
        this.contractsInAgreementRepository.deleteById(contract.getId());
    }
}
