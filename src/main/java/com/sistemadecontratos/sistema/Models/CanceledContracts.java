package com.sistemadecontratos.sistema.Models;

import com.sistemadecontratos.sistema.Models.Abstract.Contract;
import jakarta.persistence.*;

@Entity
@Table(name = "Contratos_Cancelados")
public class CanceledContracts extends Contract {

    public CanceledContracts() {}

}
