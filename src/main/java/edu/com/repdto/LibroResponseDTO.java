package edu.com.repdto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema (description = "Prestancion para Listar Libros con usuario")
public class LibroResponseDTO {

	
	
	@Schema (description = "Id libro")
	private Integer idLibro;
	
	@Schema (description  = "Titulo libro")
    private String titulo;
	
	@Schema (description = "Solo nombre autor")
    private String nombreAutor;
    
    
    //
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
    
    
}
