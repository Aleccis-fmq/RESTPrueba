package edu.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Schema (description  = "TITLE")
public class UsuariosDTO {

	
	private Integer idUsuario;
	
	@Schema (description  = "Data")
	@NotNull
	@Size(min = 3,message = "{nombres.size}")
	private String nombre;
	
	@Schema (description  = "Data")
	@NotNull
	@NotEmpty
	@Email
	private String correo;
	
	@Schema (description  = "Data")
	@NotNull
	@Size(min = 2,max = 4 , message = "{edad.size}")
	private String edad;
	
	//GTS
	
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
