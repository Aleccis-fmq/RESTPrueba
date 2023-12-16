package edu.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuariosDTO {

	
	private Integer idUsuario;
	
	@NotNull
	private String nombre;
	@NotNull
	private String correo;
	@NotNull
	private String edad;
	
	
}
