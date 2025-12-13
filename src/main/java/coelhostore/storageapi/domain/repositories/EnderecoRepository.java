package coelhostore.storageapi.domain.repositories;

import coelhostore.storageapi.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Optional<Endereco>findById(UUID uuid);
}
