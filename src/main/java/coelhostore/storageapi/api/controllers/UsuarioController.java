package coelhostore.storageapi.api.controllers;

import coelhostore.storageapi.api.dtos.UsuarioRequest;
import coelhostore.storageapi.api.dtos.UsuarioResponse;
import coelhostore.storageapi.api.service.UsuarioService;
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
@RequestMapping(value = "/usuario",produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioResponse>>findUserList(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findUserList());
    }
    @GetMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<UsuarioResponse>>findUserId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findUserId(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UsuarioRequest usuarioRequest){
        usuarioService.createUser(usuarioRequest);
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable UUID id,@RequestBody UsuarioRequest usuarioRequest){
        usuarioService.updateUser(id,usuarioRequest);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id){
        usuarioService.deleteUser(id);
    }
}
