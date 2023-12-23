package edu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.model.Prestamos;
import edu.com.service.IPrestamoService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamosController {

	//service
	@Autowired
	private IPrestamoService iPrestamoService;
	
	//Listar
	@GetMapping("/0")
	public List<Prestamos> listar() throws Exception{
		return iPrestamoService.listar();
	}
	
	
}
