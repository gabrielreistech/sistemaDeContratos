package com.sistemadecontratos.sistema.Beans;

import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.ModelsContracts.ContractsInAgreement;
import com.sistemadecontratos.sistema.Models.ModelsContracts.CurrentContracts;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import com.sistemadecontratos.sistema.Repositorys.ContractsInAgreementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MethodsBeansTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ContractsInAgreementRepository contractsInAgreementRepository;

    @Mock
    ContractsInAgreement contractsInAgreement;

    @Mock
    CurrentContractsDto currentContractsDto;

    @Mock
    MethodsBeans methodsBeans;

    @BeforeEach
    @Transactional
    void setUp(){
        Client client = new Client();
        client.setName("Psicologia LTDA");
        client.setValuesInContracts(0.0);
        client.setContractsExecuted(0);
        client.setDescription("Clínica focada em tratamento de saúde mental.");
        this.clientRepository.save(client);

        ContractsInAgreement contractsInAgreement = new ContractsInAgreement();
        contractsInAgreement.setClient(client);
        contractsInAgreement.setPrice(100.00);
        contractsInAgreement.setDescription("Description test.");
        contractsInAgreement.setContractDay(LocalDateTime.now());
        contractsInAgreement.setContractEnd(LocalDateTime.now());
        contractsInAgreement.setName("Teste");
        this.contractsInAgreementRepository.save(contractsInAgreement);
    }

    @Test
    void addContractsTest(){
         when(methodsBeans.addContractsInCurrentContracts(contractsInAgreement)).thenReturn(currentContractsDto);
         methodsBeans.addContractsInCurrentContracts(contractsInAgreement);
    }

}