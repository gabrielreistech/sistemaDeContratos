package com.sistemadecontratos.sistema.Models;

import com.sistemadecontratos.sistema.Models.Abstract.Contract;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Contratos_Em_Acordo")
public class ContractsInAgreement extends Contract {

   public ContractsInAgreement(){}

}
