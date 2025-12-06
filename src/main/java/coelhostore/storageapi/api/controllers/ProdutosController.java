package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.ProdutosRequest;
import coelhostore.storageapi.api.dtos.ProdutosResponse;
import coelhostore.storageapi.api.service.ProdutosService;
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
@RequestMapping(value = "/produtos",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutosController {
    private final ProdutosService produtosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutosResponse>>findProdutosList(){
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findProdutosList());
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ProdutosResponse>>findProdutosId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findProdutosId(id));
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProdutos(@RequestBody ProdutosRequest produtosRequest){
        produtosService.createProdutos(produtosRequest);
    }
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateProdutos(@PathVariable UUID id,@RequestBody ProdutosRequest produtosRequest){
        produtosService.updateProdutos(id,produtosRequest);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdutos(@PathVariable UUID id){
        produtosService.deleteProdutos(id);
    }
}
