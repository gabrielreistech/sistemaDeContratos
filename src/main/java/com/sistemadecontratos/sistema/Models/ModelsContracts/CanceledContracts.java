package com.sistemadecontratos.sistema.Models.ModelsContracts;

import com.sistemadecontratos.sistema.Models.Client;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Contratos_Cancelados")
public class CanceledContracts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome", nullable = true)
    private String name;

    @Column(name = "Descrição", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = true, unique = true)
    private Client client;

    @Column(name = "Preço")
    private Double price;

    @Column(name = "Início_Do_Contrato")
    private LocalDateTime contractDay;

    @Column(name = "Fim_Do_Contrato")
    private LocalDateTime contractEnd;

    public CanceledContracts(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getContractDay() {
        return contractDay;
    }

    public void setContractDay(LocalDateTime contractDay) {
        this.contractDay = contractDay;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDateTime contractEnd) {
        this.contractEnd = contractEnd;
    }
}
