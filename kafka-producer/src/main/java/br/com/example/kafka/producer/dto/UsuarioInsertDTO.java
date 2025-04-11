package br.com.example.kafka.producer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UsuarioInsertDTO extends UsuarioDTO {
    @NotBlank(message = "Campo requerido")
    @Size(min = 8, message = "Senha precisa ter no mínimo 8 caracteres")
    private String senha;
    public UsuarioInsertDTO() {
        super();
    }
    public String getSenha() {
        return senha;
    }
}
