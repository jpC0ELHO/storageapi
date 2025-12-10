package coelhostore.storageapi.domain.repositories;

import coelhostore.storageapi.domain.EstoqueSaida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueSaidaRepository extends JpaRepository<EstoqueSaida, UUID> {
    Optional<EstoqueSaida>findById(UUID uuid);
}
