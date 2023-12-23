package edu.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Autores {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idAutor;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String nacionalidad;

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

	public Autores(Integer idAutor, String nombre, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public Autores() {
		super();
	}
	
	
	
	

}
