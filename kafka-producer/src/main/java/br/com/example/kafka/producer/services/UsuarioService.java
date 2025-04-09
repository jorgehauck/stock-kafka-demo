package br.com.example.kafka.producer.services;

import br.com.example.kafka.producer.dto.UsuarioInsertDTO;
import br.com.example.kafka.producer.dto.UsuarioDTO;
import br.com.example.kafka.producer.entities.Usuario;
import br.com.example.kafka.producer.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return usuario.get();
    }

    @Transactional
    public UsuarioDTO insertUsuario(UsuarioInsertDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(encoder.encode(usuarioDto.getSenha()));
        usuario.setTelefone(usuarioDto.getTelefone());

        usuario = repository.save(usuario);

        return new UsuarioDTO(usuario);
    }
}
