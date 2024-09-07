package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.SucessyContractsDto;
import com.sistemadecontratos.sistema.Dtos.SucessyContractsDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Services.SucessyContractsService;
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

@RestController
@RequestMapping("/contratosDeSucesso")
public class SucessyContractsController {

    @Autowired
    SucessyContractsService sucessyContractsService;

    @PostMapping
    public ResponseEntity<SucessyContractsDtoRespostaObjeto> create(@RequestBody @Valid SucessyContractsDto sucessyContractsDto){
        SucessyContractsDtoRespostaObjeto sucessyContracts = this.sucessyContractsService.create(sucessyContractsDto);
        URI locale = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sucessyContracts.getId()).toUri();
        return ResponseEntity.created(locale).body(sucessyContracts);
    }

    @GetMapping
    public ResponseEntity<Page<SucessyContractsDtoRespostaObjeto>> findAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "1") @Min(1) int size,
            @RequestParam(defaultValue = "name") String sort
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<SucessyContractsDtoRespostaObjeto> sucessyContractsDtoRespostaObjeto = this.sucessyContractsService.findAll(pageable);
        return  ResponseEntity.ok(sucessyContractsDtoRespostaObjeto);
    }

}
