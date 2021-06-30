package mx.com.gm.hola_spring_extension.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.gm.hola_spring_extension.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
  Usuario findByUsername(String username);
}
