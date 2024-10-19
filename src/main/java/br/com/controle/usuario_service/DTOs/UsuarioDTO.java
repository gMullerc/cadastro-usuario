package br.com.controle.usuario_service.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {

    private Long id;

    @NotNull(message = "O nome de usuário é obrigatório")
    @NotBlank(message = "O nome de usuário não pode ser vazio")
    @Size(min = 4, max = 12, message = "O nome de usuário deve ter entre 4 e 12 caracteres")
    private String nomeUsuario;

    @NotNull(message = "A senha é obrigatória")
    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;

    private String token;
}
