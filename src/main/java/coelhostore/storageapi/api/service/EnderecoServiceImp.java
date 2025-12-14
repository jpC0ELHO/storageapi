package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EnderecoRequest;
import coelhostore.storageapi.api.dtos.EnderecoResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.EnderecoRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class EnderecoServiceImp implements EnderecoService{

    private final EnderecoRepository enderecoRepository;

    @Override
    public List<EnderecoResponse> findEnderecoList() {
        var findEnderecoList=enderecoRepository.findAll();
        if (findEnderecoList.isEmpty()){
            throw new ModelNotFoundException("Endereco List not found!");
        }
        return findEnderecoList
                .stream()
                .map(EnderecoResponse::toResponse)
                .toList();
    }

    @Override
    public Optional<EnderecoResponse> findEnderecoId(UUID uuid) {
        return enderecoRepository
                .findById(uuid)
                .map(EnderecoResponse::toResponse)
                .or(()->{throw new ModelNotFoundException("Endereco ID: "+uuid+" not found!");});
    }

    @Override
    public void createEndereco(EnderecoRequest enderecoRequest) {
    enderecoRepository.save(toEntidade(enderecoRequest));
    }

    @Override
    public void updateEndereco(UUID uuid, EnderecoRequest enderecoRequest) {
        var findEnderecoId=enderecoRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("Endereco ID : "+uuid+" not found"));
        findEnderecoId.setLogradouro(enderecoRequest.logradouro());
        findEnderecoId.setNumero(enderecoRequest.numero());
        findEnderecoId.setComplemento(enderecoRequest.complemento());
        findEnderecoId.setBairro(enderecoRequest.bairro());
        findEnderecoId.setCidade(enderecoRequest.cidade());
        findEnderecoId.setEstado(enderecoRequest.estadoBr());
        findEnderecoId.setCep(enderecoRequest.cep());
        enderecoRepository.save(findEnderecoId);
    }

    @Override
    public void deleteEndereco(UUID uuid) {
    try {
        var findEnderecoId=enderecoRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("Endereco ID : "+uuid+" not found"));
        enderecoRepository.delete(findEnderecoId);
    }catch (RuntimeException e){
        log.error("Error: {} inside delete endereco!",e.getMessage());
        throw e;
    }
    }
}
