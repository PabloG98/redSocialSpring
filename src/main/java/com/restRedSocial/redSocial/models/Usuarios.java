package com.restRedSocial.redSocial.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Usuarios {
	@Id
	public ObjectId _id;
	public String nombre;
	public String apellido;
	public String nombreUsuario;
	public String correo;
	public String contrasena;
	
	public Usuarios() {}

	public Usuarios(ObjectId _id, String nombre, String apellido, String nombreUsuario, String correo,
			String contrasena) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
