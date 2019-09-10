package com.restRedSocial.redSocial.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restRedSocial.redSocial.models.Usuarios;
import com.restRedSocial.redSocial.repositories.UsuarioRepository;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List getAllUsuarios() {
	   return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Usuarios getUsuarioById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyUsuarioById(@PathVariable("id") ObjectId id, @Valid @RequestBody Usuarios usuarios) {
	   usuarios.set_id(id);
	   repository.save(usuarios);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Usuarios createUsuario(@Valid @RequestBody Usuarios usuario) {
	   usuario.set_id(ObjectId.get());
	   repository.save(usuario);
	   return usuario;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUsuario(@PathVariable ObjectId id) {
	   repository.delete(repository.findBy_id(id));
	}

}
