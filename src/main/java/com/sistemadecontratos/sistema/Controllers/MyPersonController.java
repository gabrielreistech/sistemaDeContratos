package com.sistemadecontratos.sistema.Controllers;

import com.sistemadecontratos.sistema.Dtos.MyPersonDto;
import com.sistemadecontratos.sistema.Services.MyPersonService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/myPerson")
public class MyPersonController {

    @Autowired
    MyPersonService myPersonService;

    @Operation(
            summary = "Cria um novo usuário.",
            description = "Cria um novo usuário com as informações fornecidas no corpo da requisição. " +
                    "O ID do novo usuário será gerado automaticamente e retornado no cabeçalho `Location` da resposta."
    )
    @PostMapping
    public ResponseEntity<MyPersonDto> create(@RequestBody @Valid MyPersonDto myPersonDto) {
        MyPersonDto createdPerson = this.myPersonService.create(myPersonDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPerson.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdPerson);
    }

    @Operation(
            summary = "Busca os dados do usuário.",
            description = "Busca e retorna os dados do usuário do sistema Contracts. " +
                    "Este endpoint retorna os detalhes do usuário atualmente autenticado ou associado ao sistema."
    )
    @GetMapping
    public ResponseEntity<List<MyPersonDto>> findMyPerson() {
        List<MyPersonDto> myPersonDto = this.myPersonService.findAll();
        return ResponseEntity.ok(myPersonDto);
    }

    @Operation(
            summary = "Deleta um usuário pelo nome.",
            description = "Remove um usuário do sistema com base no nome fornecido como parâmetro de consulta. " +
                    "Se o usuário for encontrado e removido com sucesso, a resposta será uma mensagem confirmando a remoção."
    )
    @DeleteMapping
    public ResponseEntity<String> deleteByName(@RequestParam String name) {
        String resultMessage = this.myPersonService.deleteByName(name);
        return ResponseEntity.ok(resultMessage);
    }
}
