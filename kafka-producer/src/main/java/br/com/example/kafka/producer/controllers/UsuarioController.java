package br.com.example.kafka.producer.controllers;

import br.com.example.kafka.producer.dto.UsuarioDTO;
import br.com.example.kafka.producer.dto.UsuarioInsertDTO;
import br.com.example.kafka.producer.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @PostMapping
    public ResponseEntity<UsuarioDTO> insertUsuario(@Valid @RequestBody UsuarioInsertDTO usuarioInsertDto) {
        UsuarioDTO novoUsuario = service.insertUsuario(usuarioInsertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(novoUsuario);
    }
}
