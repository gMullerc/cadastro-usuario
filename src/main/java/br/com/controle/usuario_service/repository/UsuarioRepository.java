package br.com.controle.usuario_service.repository;

import br.com.controle.usuario_service.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UserDetails findByNomeUsuario(String nomeUsuario);

}
