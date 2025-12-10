package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.EstoqueRequest;
import coelhostore.storageapi.api.dtos.EstoqueResponse;
import coelhostore.storageapi.api.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/estoque",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EstoqueController {
    private final EstoqueService estoqueService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstoqueResponse>>findEstoqueList(){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueService.findEstoqueList());
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EstoqueResponse>>findEstoqueId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueService.findEstoqueId(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEstoque(@RequestBody EstoqueRequest estoqueRequest){
        estoqueService.createEstoque(estoqueRequest);
    }
    @PutMapping(value = "{/id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEstoque(@PathVariable UUID id,@RequestBody EstoqueRequest estoqueRequest){
        estoqueService.updateEstoque(id,estoqueRequest);
    }
    @DeleteMapping(value = "{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstoque(@PathVariable UUID id){
        estoqueService.deleteEstoque(id);
    }

}
