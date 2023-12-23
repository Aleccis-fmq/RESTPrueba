package edu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.model.Libros;
import edu.com.service.ILibrosService;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

	//service
	@Autowired
	private ILibrosService iLibrosService;
	
	//Listar
	@GetMapping("/0")
	public List<Libros> listar() throws Exception{
		return iLibrosService.listar();
	}
	
	
	
	
}
