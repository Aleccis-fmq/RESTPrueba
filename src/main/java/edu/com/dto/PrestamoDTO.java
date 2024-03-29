package edu.com.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema (description  = "TITLE")
public class PrestamoDTO {

	
	private Integer idPrestamo;
	
	@Schema (description  = "Data")
	@NotEmpty
	@NotNull
	@Size()
	private LocalDateTime fechaPrestamo;
	
	@Schema (description  = "Data")
	@NotEmpty
	@Size()
	private LocalDateTime fechaDevolucion;
	
	//FKS
	@Schema (description  = "Data")
	@NotEmpty
	private LibrosDTO librodto;
	
	@Schema (description  = "Data")
	@NotEmpty
	private UsuariosDTO usuariodto;
	
	//gts
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
	public LibrosDTO getLibrodto() {
		return librodto;
	}
	public void setLibrodto(LibrosDTO librodto) {
		this.librodto = librodto;
	}
	public UsuariosDTO getUsuariodto() {
		return usuariodto;
	}
	public void setUsuariodto(UsuariosDTO usuariodto) {
		this.usuariodto = usuariodto;
	}
	
	//gts
	
	
}
