package com.sistemadecontratos.sistema.Models.Abstract;

import com.sistemadecontratos.sistema.Models.Client;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nome", nullable = true)
    private String name;

    @Column(name = "Descrição", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Client client;

    @Column(name = "Preço")
    private Double price;

    @Column(name = "Início_Do_Contrato")
    private LocalDate contractDay;

    @Column(name = "Fim_Do_Contrato")
    private LocalDate contractEnd;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getContractDay() {
        return contractDay;
    }

    public void setContractDay(LocalDate contractDay) {
        this.contractDay = contractDay;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id) && Objects.equals(name, contract.name) && Objects.equals(description, contract.description) && Objects.equals(client, contract.client) && Objects.equals(price, contract.price) && Objects.equals(contractDay, contract.contractDay) && Objects.equals(contractEnd, contract.contractEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, client, price, contractDay, contractEnd);
    }
}
