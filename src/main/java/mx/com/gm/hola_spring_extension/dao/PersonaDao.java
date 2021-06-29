package mx.com.gm.hola_spring_extension.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.gm.hola_spring_extension.domain.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {
  
}
