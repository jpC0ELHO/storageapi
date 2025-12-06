package coelhostore.storageapi.domain.repositories;

import coelhostore.storageapi.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutosRepository extends JpaRepository<Produtos, UUID> {
    Optional<Produtos>findById(UUID uuid);
}
