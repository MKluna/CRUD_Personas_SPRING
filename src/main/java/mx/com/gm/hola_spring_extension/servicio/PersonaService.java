package mx.com.gm.hola_spring_extension.servicio;

import java.util.List;

import mx.com.gm.hola_spring_extension.domain.Persona;

public interface PersonaService {
  public List<Persona> listarPersona();

  public void guardar(Persona persona);

  public void eliminar(Persona persona);

  public Persona encontrarPersona(Persona persona);
}
