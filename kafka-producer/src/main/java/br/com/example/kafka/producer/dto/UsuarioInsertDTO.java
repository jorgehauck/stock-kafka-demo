package br.com.example.kafka.producer.dto;

public class UsuarioInsertDTO extends UsuarioDTO {
    private String senha;
    public UsuarioInsertDTO() {
        super();
    }
    public String getSenha() {
        return senha;
    }
}
