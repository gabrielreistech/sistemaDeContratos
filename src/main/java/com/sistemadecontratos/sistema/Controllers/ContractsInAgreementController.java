package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.ContractsInAgreementDto;
import com.sistemadecontratos.sistema.Dtos.ContractsInAgreementDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Dtos.CurrentContractsDto;
import com.sistemadecontratos.sistema.Services.ContractInAgreementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Contratos em Acordo", description = "Contém todo CRUD da classe Contratos em acordo")
@RestController
@RequestMapping("/contratosEmAcordo")
public class ContractsInAgreementController {

    @Autowired
    ContractInAgreementService contractInAgreementService;

    @Operation(summary = "Salva um novo contrato.", description = "Esse método ele salva um novo contrato no banco de dados Contratos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contrato em acordo criado com sucesso."),
            @ApiResponse(responseCode = "409", description = "Por algum mótivo seu contrato em acordo não conseguiu ser criado no sistema")
    })
    @PostMapping
    public ResponseEntity<ContractsInAgreementDtoRespostaObjeto> save(@Valid @RequestBody ContractsInAgreementDto contractsInAgreementDto){
        ContractsInAgreementDtoRespostaObjeto contractsInAgreementDtoRespostaObjeto = this.contractInAgreementService.save(contractsInAgreementDto);
        URI locate = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contractsInAgreementDtoRespostaObjeto.getId()).toUri();
        return ResponseEntity.created(locate).body(contractsInAgreementDtoRespostaObjeto);
    }

    @Operation(summary = "Buscar todos contratos em acordo.", description = "Busca de forma paginada todos os contratos que estão em modo de acordo ainda.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos contratos em acordo buscados com sucesso.")
    })
    @GetMapping
    public ResponseEntity<Page<ContractsInAgreementDtoRespostaObjeto>> findAll(@RequestParam(defaultValue = "0") @Min(0) int page, @RequestParam(defaultValue = "10") @Min(1) int size, @RequestParam(defaultValue = "name") String sort){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sort).ascending());
        Page<ContractsInAgreementDtoRespostaObjeto> result = this.contractInAgreementService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Busca um contrato em acordo por ID.", description = "Método que busca pelo ID, um contrato em acordo.")
    @GetMapping("/{id}")
    public ResponseEntity<ContractsInAgreementDtoRespostaObjeto> findById(@PathVariable Long id){
        ContractsInAgreementDtoRespostaObjeto contractById = this.contractInAgreementService.findById(id);
        return ResponseEntity.ok(contractById);
    }

    @Operation(summary = "Deleta um contrato em acordo pelo seu ID.", description = "Método que deleta um contrato em acordo pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.contractInAgreementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
