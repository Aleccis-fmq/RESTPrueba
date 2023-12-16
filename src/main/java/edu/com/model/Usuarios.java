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
	
	
}
