package com.sistemadecontratos.sistema.Services;

import com.sistemadecontratos.sistema.Dtos.ClientDto;
import com.sistemadecontratos.sistema.Dtos.ClientDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientDtoRespostaObjeto save(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setDescription(clientDto.getDescription());
        if(clientDto.getContractsExecuted() >= 0) {
            client.setContractsExecuted(clientDto.getContractsExecuted());
        } else if(clientDto.getContractsExecuted() == null){
            client.setContractsExecuted(0);
        }
        if(clientDto.getValuesInContracts() >= 0){
            client.setValuesInContracts(clientDto.getValuesInContracts());
        } else if(clientDto.getValuesInContracts() == null){
            client.setValuesInContracts(0.0);
        }
        Client clientSave = this.clientRepository.save(client);

        return new ClientDtoRespostaObjeto(clientSave);
    }

    public Page<ClientDtoRespostaObjeto> findAll(Pageable pageable){
        Page<Client> page = this.clientRepository.findAll(pageable);
        return page.map(ClientDtoRespostaObjeto::new);
    }

    public void deleteById(Long id){
        Client client = this.clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não localizado para ser deletado."));
        this.clientRepository.deleteById(id);
    }
}
