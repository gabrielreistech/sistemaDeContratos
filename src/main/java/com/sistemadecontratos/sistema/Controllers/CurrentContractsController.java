package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Services.CurrentContractsService;
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

    @Operation(summary = "Adicionar um contrato em acordo dentro de um contrato atual", description = "Método que busca um Contrato em Acordo e põe dentro de um Contrato Atual.")
    @PostMapping
    public ResponseEntity<CurrentContractsDto> addContract(@RequestParam Long id){
        CurrentContractsDto currentContractsDto = this.currentContractsService.addContract(id);
        return ResponseEntity.ok(currentContractsDto);
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
