package coelhostore.storageapi.domain.repositories;

import coelhostore.storageapi.domain.EstoqueEntrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueEntradaRepository extends JpaRepository<EstoqueEntrada, UUID> {
    Optional<EstoqueEntrada>findById(UUID uuid);
}
