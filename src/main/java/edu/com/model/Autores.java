package edu.com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Autores {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idAutor;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String nacionalidad;

}
