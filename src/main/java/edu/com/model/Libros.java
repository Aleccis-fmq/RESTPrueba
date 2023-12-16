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
@NoArgsConstructor
@Data
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
}
