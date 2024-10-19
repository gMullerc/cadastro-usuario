package br.com.controle.usuario_service.factories;

import br.com.controle.usuario_service.DTOs.UsuarioDTO;
import br.com.controle.usuario_service.models.UsuarioEntity;

public class UsuarioFactory {

    public static UsuarioEntity toEntity(UsuarioDTO usuarioDTO) {

        return UsuarioEntity.builder()
                .nomeUsuario(usuarioDTO.getNomeUsuario())
                .senha(usuarioDTO.getSenha())
                .build();
    }

    public static UsuarioDTO toDTO(UsuarioEntity usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nomeUsuario(usuario.getNomeUsuario())
                .senha(usuario.getSenha())
                .token(usuario.getToken())
                .build();
    }

}
