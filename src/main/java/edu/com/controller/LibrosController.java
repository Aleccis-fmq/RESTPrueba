package edu.com.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.model.Libros;
import edu.com.repdto.LibroResponseDTO;
import edu.com.service.ILibrosService;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

	// service
	@Autowired
	private ILibrosService iLibrosService;

	// Listar
	@GetMapping("/0")
	public List<Libros> listar() throws Exception {
		return iLibrosService.listar();
	}

	// ListarDtoResponse
	@GetMapping("/1")
	public ResponseEntity<List<LibroResponseDTO>> listarr2() {
		try {
			// lista
			List<Libros> libros = iLibrosService.listar();

			// Mapear libros a LibroResponseDTO
			List<LibroResponseDTO> responseDTOs = libros.stream().map(libro -> {
				LibroResponseDTO dto = new LibroResponseDTO();
				dto.setIdLibro(libro.getIdLibro());
				dto.setTitulo(libro.getTitulo());
				dto.setNombreAutor(libro.getAutor().getNombre());
				return dto;
			}).collect(Collectors.toList());
			return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
		} catch (Exception e) {
			// Log the exception or return a custom error response
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//
	/*
	@GetMapping("/listar")
	public ResponseEntity<List<LibroResponseDTO>> listar() {
		try {
			// Lista de libros desde el servicio
			List<Libros> libros = iLibrosService.listar();

			// Lista de DTOs
			List<LibroResponseDTO> responseDTOs = new ArrayList<>();

			// Iterar sobre la lista de libros y construir los DTOs manualmente
			for (Libros libro : libros) {
				LibroResponseDTO dto = new LibroResponseDTO();
				dto.setIdLibro(libro.getIdLibro());
				dto.setTitulo(libro.getTitulo());
				dto.setNombreAutor(libro.getAutor().getNombre());
				responseDTOs.add(dto);
			}

			// Devolver la lista de DTOs en la respuesta con código 200 OK
			return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
		} catch (Exception e) {
			// Manejar excepciones y devolver código de error 500 Internal Server Error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	
	public static int factorial(int n) {
	    return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
	}
	
	//
	private List<LibroResponseDTO> mapLibrosToDTO(List<Libros> libros) {
        if (libros == null || libros.isEmpty()) {
            return Collections.emptyList();
        }

        // Mapear el primer libro y llamar recursivamente para el resto de la lista
        Libros firstLibro = libros.get(0);
        List<Libros> restOfLibros = libros.subList(1, libros.size());

        LibroResponseDTO responseDTO = new LibroResponseDTO();
        responseDTO.setIdLibro(firstLibro.getIdLibro());
        responseDTO.setTitulo(firstLibro.getTitulo());
        responseDTO.setNombreAutor(firstLibro.getAutor().getNombre());

        List<LibroResponseDTO> restOfResponseDTOs = mapLibrosToDTO(restOfLibros);
        restOfResponseDTOs.add(0, responseDTO);  // Agregar el resultado actual al principio

        return restOfResponseDTOs;
    }
	
	//
	//List<Integer> numbers = Arrays.asList(a, a, a, a,a);

	// Uso de expresiones lambda en una operación de map
	//List<Integer> squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());


}
