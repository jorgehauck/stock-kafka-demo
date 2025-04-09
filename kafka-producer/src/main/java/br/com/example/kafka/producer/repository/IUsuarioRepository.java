package br.com.example.kafka.producer.repository;

import br.com.example.kafka.producer.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
}
