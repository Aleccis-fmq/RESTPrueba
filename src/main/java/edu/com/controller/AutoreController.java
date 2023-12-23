package edu.com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.dto.AutoresDTO;
import edu.com.model.Autores;
import edu.com.service.IAutorService;

@RestController
@RequestMapping("/api/autores")
public class AutoreController {

	// service
	@Autowired
	private IAutorService autorService;

	// amper
	@Autowired
	private ModelMapper mapper;

	// listar

	@GetMapping("/0")
	public List<Autores> listar() throws Exception {
		return autorService.listar();
	}
	
	// x id
	@GetMapping("/0/{id}")
	public Autores autorxid(@PathVariable("id")Integer id) throws Exception {
		return autorService.listarPorId(id);
	}
	

	// LISTAR
	@GetMapping("/3")
	public ResponseEntity<List<AutoresDTO>> listar3() throws Exception {
		List<AutoresDTO> lista = autorService.listar().stream().map(p -> mapper.map(p, AutoresDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
