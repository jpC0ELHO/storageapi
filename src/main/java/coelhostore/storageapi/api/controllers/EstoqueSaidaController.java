package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.EstoqueSaidaRequest;
import coelhostore.storageapi.api.dtos.EstoqueSaidaResponse;
import coelhostore.storageapi.api.service.EstoqueSaidaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/estoque_saida",consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@RestController
public class EstoqueSaidaController {
    private final EstoqueSaidaService estoqueSaidaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstoqueSaidaResponse>>findEstoqueSaidaList(){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueSaidaService.findEstoqueSaidaList());
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EstoqueSaidaResponse>>findEstoqueSaidaId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueSaidaService.findEstoqueSaidaId(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEstoqueSaida(@RequestBody EstoqueSaidaRequest estoqueSaidaRequest){
        estoqueSaidaService.createEstoqueSaida(estoqueSaidaRequest);
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEstoqueSaida(@PathVariable UUID id,@RequestBody EstoqueSaidaRequest estoqueSaidaRequest){
        estoqueSaidaService.updateEstoqueSaida(id,estoqueSaidaRequest);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstoqueSaida(@PathVariable UUID id){
        estoqueSaidaService.deleteEstoqueSaida(id);
    }
}
