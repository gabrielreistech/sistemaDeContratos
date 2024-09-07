package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Models.Client;
import com.sistemadecontratos.sistema.Repositorys.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    WebTestClient webTestClient;

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

        webTestClient.get().uri("/clientes?page=0&size=10")
                        .exchange().expectStatus().isOk()
                        .expectBody()
                                .jsonPath("$.content[0].id").isEqualTo(ClientID)
                                .jsonPath("$.content[1].id").isEqualTo(ClientID2);

    }

    @Test
    @Order(2)
    void findByIdClient() throws Exception {
            webTestClient.get()
                    .uri("/clientes/{id}", ClientID).exchange().expectStatus().isOk();
    }

    @Test
    @Order(3)
    void deleteByIdClient() throws Exception {
        webTestClient.get().uri("/clientes/{id}", ClientID).exchange().expectStatus().isOk();
    }

}
