package edu.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class UsuariosDTO {

	
	private Integer idUsuario;
	
	@NotNull
	@Size(min = 3,message = "Nombres minimo 3")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Email
	private String correo;
	
	@NotNull
	@Size(min = 2,max = 4 , message = "Edad ser >18")
	private String edad;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	
	
	
}
