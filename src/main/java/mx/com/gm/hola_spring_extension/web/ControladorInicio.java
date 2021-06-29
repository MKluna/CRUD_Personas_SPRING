package mx.com.gm.hola_spring_extension.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.hola_spring_extension.domain.Persona;
import mx.com.gm.hola_spring_extension.servicio.PersonaService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControladorInicio {

  @Autowired
  private PersonaService personaService;

  @GetMapping("/")
  public String inicio(Model model) {
    var personas = personaService.listarPersona();
    log.info("Desde el controlador Spring MVC");
    model.addAttribute("personas", personas);
    return "index";
  }

  @GetMapping("/agregar")
  public String agregar(Persona persona) {
    return "modificar";
  }

  @PostMapping("/guardar")
  public String guardar(@Valid Persona persona, Errors errores) {
    if (errores.hasErrors()) {
      return "modificar";
    }
    personaService.guardar(persona);
    return "redirect:/";
  }

  @GetMapping(value = "/editar/{idPersona}")
  public String editar(Persona persona, Model model) {
    persona = personaService.encontrarPersona(persona);
    model.addAttribute("persona", persona);
    return "modificar";
  }

  @GetMapping(value = "/eliminar")
  public String eliminar(Persona persona, Model model) {
    personaService.eliminar(persona);
    return "redirect:/";
  }

}
