package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.EnderecoRequest;
import coelhostore.storageapi.api.dtos.EnderecoResponse;
import coelhostore.storageapi.api.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/endereco",produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {
    private final EnderecoService enderecoService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EnderecoResponse>> findEnderecoList(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findEnderecoList());
    }

    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EnderecoResponse>>findEnderecoId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findEnderecoId(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void createEndereco(@RequestBody EnderecoRequest enderecoRequest){
        enderecoService.createEndereco(enderecoRequest);
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEndereco(@PathVariable UUID id,@RequestBody EnderecoRequest enderecoRequest){
        enderecoService.updateEndereco(id, enderecoRequest);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteEndereco(@PathVariable UUID id){
        enderecoService.deleteEndereco(id);
    }
}
