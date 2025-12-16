package coelhostore.storageapi.domain.repositories;

import coelhostore.storageapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario>findById(UUID uuid);
}
