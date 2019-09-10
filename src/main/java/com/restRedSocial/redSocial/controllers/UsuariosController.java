package com.restRedSocial.redSocial.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.restRedSocial.redSocial.DTO.JwtDTO;
import com.restRedSocial.redSocial.DTO.Mensaje;
import com.restRedSocial.redSocial.models.Usuarios;
import com.restRedSocial.redSocial.security.JWT.*;
import com.restRedSocial.redSocial.repositories.UsuarioRepository;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	//@Autowired
    //AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
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
	
	//@PostMapping("/login")
    //public ResponseEntity<JwtDTO> login(@Valid @RequestBody Usuarios loginUsuario, BindingResult bindingResult){
        //if(bindingResult.hasErrors())
            //return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        //Authentication authentication = authenticationManager.authenticate(
                //new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getContrasena())
        //);
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //String jwt = jwtProvider.generateToken(authentication);
        //UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        //return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    //}

}
