package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.ClientDto;
import com.sistemadecontratos.sistema.Dtos.ClientDtoRespostaObjeto;
import com.sistemadecontratos.sistema.Services.ClientService;
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


@Tag(name = "Clientes", description = "Contém todo CRUD da classe Clientes.")
@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Operation(summary = "Salva um novo cliente.", description = "Esse método salva um novo cliente no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente buscado com sucesso."),
    })
    @PostMapping
    public ResponseEntity<ClientDtoRespostaObjeto> insert(@Valid @RequestBody ClientDto clientDto){
        ClientDtoRespostaObjeto clientDtoRespostaObjeto = this.clientService.create(clientDto);
        URI locate = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientDtoRespostaObjeto.getId()).toUri();
        return ResponseEntity.created(locate).body(clientDtoRespostaObjeto);
    }

    @Operation(summary = "Busca todos clientes.", description = "Método que busca todos os clientes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos clientes buscados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Clientes não conseguiram ser buscado no sistema.")
    })
    @GetMapping
    public ResponseEntity<Page<ClientDtoRespostaObjeto>> findAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(defaultValue = "name") String sort){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<ClientDtoRespostaObjeto> result = this.clientService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Busca um cliente por ID.", description = "Método que busca um cliente pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDtoRespostaObjeto> findById(@PathVariable Long id){
        ClientDtoRespostaObjeto result = this.clientService.findById(id);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Deleta um cliente por ID.", description = "Método que delete um cliente pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
