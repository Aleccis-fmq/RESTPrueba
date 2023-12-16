package edu.com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.dto.UsuariosDTO;
import edu.com.model.Usuarios;
import edu.com.service.IUsuariosService;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosController {

	//service
	@Autowired
	private IUsuariosService service;
	
	
	//amper
	@Autowired
	private ModelMapper mapper;
	
	
	/*
	//LISTAR
	@GetMapping
	public ResponseEntity<List<UsuariosDTO>> listarr()throws Exception{
		List<UsuariosDTO> lista = service.listar().stream().map(p -> mapper.map(p,UsuariosDTO.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<> (lista,HttpStatus.OK);
	}
	*/
	
	
	//LISTAR MODELO
	@GetMapping
	public List<UsuariosDTO> listarUsuariosDTOs() throws Exception{
		List<Usuarios> usuarios = service.listar();
		
		List<UsuariosDTO> usuariosDTOs = usuarios.stream()
				.map(usu -> mapper.map(usu, UsuariosDTO.class))
				.collect(Collectors.toList());
		return usuariosDTOs;
	}
	
}
