package edu.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Libros {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(nullable = false)
	private String titulo;
	
	//ManyToOne
	@ManyToOne
	@JoinColumn(name = "id_autor",nullable =  false,
	foreignKey = @ForeignKey (name = "FK_libros_autores"))
	private Autores autor;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autores getAutor() {
		return autor;
	}

	public void setAutor(Autores autor) {
		this.autor = autor;
	}

	public Libros(Integer idUsuario, String titulo, Autores autor) {
		super();
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	
}
