package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.EstoqueEntradaRequest;
import coelhostore.storageapi.api.dtos.EstoqueEntradaResponse;
import coelhostore.storageapi.api.service.EstoqueEntradaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/estoque_entrada",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@RestController
public class EstoqueEntradaController {
    private final EstoqueEntradaService estoqueEntradaService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstoqueEntradaResponse>>findEstoqueEntradaList(){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueEntradaService.findEstoqueEntradaList());
    }

    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EstoqueEntradaResponse>>findEstoqueEntradaId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueEntradaService.findEstoqueEntradaId(id));
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEstoqueEntrada(@RequestBody EstoqueEntradaRequest estoqueEntradaRequest){
        estoqueEntradaService.createEstoqueEntrada(estoqueEntradaRequest);
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEstoqueEntrada(@PathVariable UUID id,@RequestBody EstoqueEntradaRequest estoqueEntradaRequest){
        estoqueEntradaService.updateEstoqueEntrada(id,estoqueEntradaRequest);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstoqueEntrada(@PathVariable UUID id){
        estoqueEntradaService.deleteEstoqueEntrada(id);
    }
}
