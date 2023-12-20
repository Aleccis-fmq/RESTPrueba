package edu.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity

public class Usuarios {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String correo;
	
	@Column(nullable = false)
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

	public Usuarios(Integer idUsuario, String nombre, String correo, String edad) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.edad = edad;
	}

	public Usuarios() {
		super();
	}
	
	
	
	
	
}
