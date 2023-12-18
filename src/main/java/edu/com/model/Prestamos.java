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

	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDateTime getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Libros getLibro() {
		return libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}

	public Prestamos(Integer idPrestamo, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, Usuarios usuario,
			Libros libro) {
		super();
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.usuario = usuario;
		this.libro = libro;
	}
	
	
}
