package edu.com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.dto.UsuariosDTO;
import edu.com.model.Usuarios;
import edu.com.service.IUsuariosService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	//service
	@Autowired
	private IUsuariosService service;
	
	
	//amper
	@Autowired
	private ModelMapper mapper;
	
	
	
	//Modelo
	//LISTAR 
	@GetMapping
	public List<Usuarios> listar() throws Exception{
		return service.listar();
	}
	
	//REGISTRAR
	@PostMapping
	public Usuarios registrar(@RequestBody Usuarios usu) throws Exception{
		return service.registrar(usu);
	}
	
	//LISTAR
	/*
	@GetMapping
	public ResponseEntity<List<Usuarios>> listarr()throws Exception{
		List<Usuarios> lista = service.listar().stream().map(p -> mapper.map(p,Usuarios.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<> (lista,HttpStatus.OK);
	}
	*/
	
	
	
	//LISTAR MODELO
	/*
	@GetMapping
	public List<Usuarios> listarUsuariosDTOs() throws Exception{
		List<Usuarios> usuarios = service.listar();
		
		List<Usuarios> usuariosDTOs = usuarios.stream()
				.map(usu -> mapper.map(usu, Usuarios.class))
				.collect(Collectors.toList());
		return usuariosDTOs;
	}
	*/
	
}
