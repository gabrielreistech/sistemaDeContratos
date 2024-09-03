package com.sistemadecontratos.sistema.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import com.sistemadecontratos.sistema.Services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    private Long ClientID;

    private Long ClientID2;

    @BeforeEach
    @Transactional
    void setUp() throws Exception {
        clientRepository.deleteAll();

        Client client = new Client();
        client.setName("Psicologia LTDA");
        client.setValuesInContracts(0.0);
        client.setContractsExecuted(0);
        client.setDescription("Clínica focada em tratamento de saúde mental.");

        client = clientRepository.save(client);
        ClientID = client.getId();

        Client client2 = new Client();
        client2.setName("Psicologia LTDA 2");
        client2.setValuesInContracts(0.0);
        client2.setContractsExecuted(0);
        client2.setDescription("Clínica focada em tratamento de saúde mental. 2");

        client2 = clientRepository.save(client2);
        ClientID2 = client2.getId();
    }

    @Test
    @Order(1)
    void findAllClients() throws Exception{

        mockMvc.perform(get("/clientes?page=0&size=10")  // Passa parâmetros de paginação se necessário
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())  // Verifica se o conteúdo é um array
                .andExpect(jsonPath("$.content.length()").value(2))  // Verifica a quantidade de clientes retornados
                .andExpect(jsonPath("$.content[0].name").value("Psicologia LTDA"))
                .andExpect(jsonPath("$.content[1].name").value("Psicologia LTDA 2"))
                .andExpect(jsonPath("$.totalElements").value(2))  // Verifica o total de elementos, se disponível
                .andExpect(jsonPath("$.totalPages").value(1))  // Verifica o total de páginas, se disponível
                .andExpect(jsonPath("$.number").value(0));
    }

    @Test
    @Order(2)
    void findByIdClient() throws Exception {
        mockMvc.perform(get("/clientes/{id}", ClientID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ClientID))
                .andExpect(jsonPath("$.name").value("Psicologia LTDA"));
    }

    @Test
    @Order(3)
    void deleteByIdClient() throws Exception {
        mockMvc.perform(delete("/clientes/{id}", ClientID))
                .andExpect(status().isNoContent());
    }

}
