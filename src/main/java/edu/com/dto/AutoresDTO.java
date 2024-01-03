package edu.com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema (description  = "TITLE")
public class AutoresDTO {

	
	
	private Integer idAutor;
	
	@Schema (description  = "Data")
	@NotNull
	@Size(min = 3,message = "{nombres.size}")
	private String nombre;
	
	@Schema (description  = "Data")
	@NotNull
	@Size(min = 2,message = "{nacionalidad.size}")
	private String nacionalidad;

	
	
	//GTS
	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
}
