package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Dtos.CurrentContractsDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Dtos.SucessyContractsDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Services.CurrentContractsService;
import com.sistemadecontratos.sistema.Services.SucessyContractsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Contratos Atuais", description = "Contém todo CRUD da classe Contratos atuais.")
@RestController
@RequestMapping("/contratosAtuais")
public class CurrentContractsController {

    @Autowired
    CurrentContractsService currentContractsService;

    @Autowired
    SucessyContractsService sucessyContractsService;

    @Operation(summary = "Adicionar um contrato atual em um contrato de sucesso.", description = "Método que adicionar um Contrato Atual em um Contrato de Sucesso.")
    @PostMapping
    public ResponseEntity<SucessyContractsDtoRespostaObjeto> insertInSucessyContracts(Long id){
         SucessyContractsDtoRespostaObjeto sucessyContract = this.sucessyContractsService.insertContract(id);
         return ResponseEntity.ok(sucessyContract);
    }



    @Operation(summary = "Buscar todos Contratos Atuais.", description = "Método que busca todos os Contratos Atuais.")
    @GetMapping
    public ResponseEntity<Page<CurrentContractsDto>> findAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(defaultValue = "name") String sort){

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        Page<CurrentContractsDto> result =  this.currentContractsService.findAll(pageable);

        return ResponseEntity.ok(result);
    }
}
