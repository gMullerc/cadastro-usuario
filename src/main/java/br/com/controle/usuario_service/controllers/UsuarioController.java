package br.com.controle.usuario_service.controllers;


import br.com.controle.usuario_service.DTOs.TokenResponseDTO;
import br.com.controle.usuario_service.DTOs.UsuarioDTO;
import br.com.controle.usuario_service.infra.security.TokenService;
import br.com.controle.usuario_service.models.UsuarioEntity;
import br.com.controle.usuario_service.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private AuthenticationManager authenticationManager;
    private UsuarioService usuarioService;
    private TokenService tokenService;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UsuarioDTO usuario) {

        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid UsuarioDTO usuario) {

        UsernamePasswordAuthenticationToken senhaUsuario = new UsernamePasswordAuthenticationToken(usuario.getNomeUsuario(), usuario.getSenha());

        Authentication auth = authenticationManager.authenticate(senhaUsuario);

        String token = tokenService.gerarToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(TokenResponseDTO.builder().token(token).build());
    }



}
