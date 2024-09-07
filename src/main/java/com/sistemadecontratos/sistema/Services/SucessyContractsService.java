package com.sistemadecontratos.sistema.Services;

import com.sistemadecontratos.sistema.Beans.MethodsBeans;
import com.sistemadecontratos.sistema.Dtos.SucessyContractsDto;
import com.sistemadecontratos.sistema.Dtos.SucessyContractsDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Models.CurrentContracts;
import com.sistemadecontratos.sistema.Models.SucessyContracts;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import com.sistemadecontratos.sistema.Repositorys.CurrentContractsRepository;
import com.sistemadecontratos.sistema.Repositorys.SucessyContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SucessyContractsService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SucessyContractsRepository sucessyContractsRepository;

    @Autowired
    CurrentContractsRepository currentContractsRepository;

    @Autowired
    MethodsBeans methodsBeans;

       @Transactional
       public SucessyContractsDtoRespostaObjeto create(SucessyContractsDto sucessyContractsDto){
           Client client = clientRepository.findById(sucessyContractsDto.getClient()).orElseThrow(() -> new RuntimeException("Cliente não foi encontrado para ser adicionado aos contratos de sucesso."));

           SucessyContracts contracts = new SucessyContracts();
           contracts.setName(sucessyContractsDto.getName());
           contracts.setDescription(sucessyContractsDto.getDescription());
           contracts.setPrice(sucessyContractsDto.getPrice());
           contracts.setClient(client);
           contracts.setContractDay(sucessyContractsDto.getContractDay());
           contracts.setContractEnd(sucessyContractsDto.getContractEnd());

           SucessyContracts contractsSave = this.sucessyContractsRepository.save(contracts);

           return new SucessyContractsDtoRespostaObjeto(contractsSave);
       }

       @Transactional
       public SucessyContractsDtoRespostaObjeto insertContract(Long id){

           CurrentContracts currentContracts = this.currentContractsRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrato em andamento não encontrado para ser adicionado aos Contratos de Sucesso."));

           SucessyContracts sucessyContracts = methodsBeans.insertContractsInSucessyContracts(currentContracts);

           return new SucessyContractsDtoRespostaObjeto(sucessyContracts);
       }

       @Transactional
       public Page<SucessyContractsDtoRespostaObjeto> findAll(Pageable pageable){
           Page<SucessyContracts> sucessyContracts = this.sucessyContractsRepository.findAll(pageable);
           return sucessyContracts.map(SucessyContractsDtoRespostaObjeto::new);
       }
}
