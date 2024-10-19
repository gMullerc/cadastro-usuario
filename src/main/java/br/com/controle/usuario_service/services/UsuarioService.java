package br.com.controle.usuario_service.services;

import br.com.controle.usuario_service.DTOs.UsuarioDTO;
import br.com.controle.usuario_service.factories.UsuarioFactory;
import br.com.controle.usuario_service.models.UsuarioEntity;
import br.com.controle.usuario_service.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Transactional
    public void cadastrarUsuario(UsuarioDTO usuario) {

        if(usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()) != null)
            throw new RuntimeException("Usuário já cadastrado no sistema");

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());

        usuario.setSenha(senhaCriptografada);

        UsuarioEntity usuarioEntity = UsuarioFactory.toEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

}
