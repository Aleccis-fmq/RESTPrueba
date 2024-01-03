package edu.com.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Schema (description  = "TITLE")
public class LibrosDTO {

	private Integer IdLibro;
	
	@Schema (description  = "Data")
	@NotEmpty
	@Size(min = 5 , message = "{titulo.size}")
	private String titulo;


	@Schema (description  = "Data")
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
