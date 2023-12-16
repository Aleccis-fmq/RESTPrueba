package edu.com.model;

import java.time.LocalDateTime;

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
public class Prestamos {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idPrestamo;
	
	//cont
	
	@Column(nullable = false)
	private LocalDateTime fechaPrestamo;
	
	@Column(nullable = false)
	private LocalDateTime fechaDevolucion;
	
	
	//fk
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable =  false,
	foreignKey = @ForeignKey (name = "FK_prestamo_usuario"))
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_libro", nullable =  false,
	foreignKey = @ForeignKey (name = "FK_prestamo_libro"))
	private Libros libro;
	
	
}
