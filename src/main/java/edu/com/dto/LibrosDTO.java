package edu.com.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LibrosDTO {

	private Integer IdLibro;
	
	
	@NotEmpty
	@Size(min = 5 , message = "{titulo.size}")
	private String titulo;


	//fk
	@NotEmpty
	private AutoresDTO autordto;
	
	//gts

	public Integer getIdLibro() {
		return IdLibro;
	}


	public void setIdLibro(Integer idLibro) {
		IdLibro = idLibro;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public AutoresDTO getAutordto() {
		return autordto;
	}


	public void setAutordto(AutoresDTO autordto) {
		this.autordto = autordto;
	}
	
}
