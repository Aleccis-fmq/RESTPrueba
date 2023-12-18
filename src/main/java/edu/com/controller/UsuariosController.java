package edu.com.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.tools.DocumentationTool.Location;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.com.dto.UsuariosDTO;
import edu.com.model.Usuarios;
import edu.com.service.IUsuariosService;
import jakarta.servlet.Servlet;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	// service
	@Autowired
	private IUsuariosService service;

	// amper
	@Autowired
	private ModelMapper mapper;

	// CREACION DE MODELO
	// LISTAR

	@GetMapping
	public List<Usuarios> listar() throws Exception {
		return service.listar();
	}

	// LISTARPORID
	@GetMapping("/{id}")
	public Usuarios listarporId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	// REGISTRAR
	@PostMapping
	public Usuarios registrar(@RequestBody Usuarios usu) throws Exception {
		return service.registrar(usu);
	}

	// MODIFICAR
	@PutMapping
	public Usuarios modificar(@RequestBody Usuarios usuarios) throws Exception {
		return service.modificar(usuarios);
	}

	// ELIMINAR
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) throws Exception {
		service.eliminar(id);
	}

	// RICH NIVEL 1 / MODELO

	// LISTAR
	@GetMapping("/1")
	public ResponseEntity<List<Usuarios>> listar1() throws Exception {
		List<Usuarios> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// LISTARPORID
	@GetMapping("/1/{id}")
	public ResponseEntity<Usuarios> listarporIdD(@PathVariable("id") Integer id) throws Exception {
		Usuarios obj = service.listarPorId(id);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// REGISTRAR
	@PostMapping("/1")
	public ResponseEntity<Usuarios> registrarr(@RequestBody Usuarios usu) throws Exception {
		Usuarios obj = service.registrar(usu);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
	}

	// MODIFICAR
	@PutMapping("/1")
	public ResponseEntity<Usuarios> modificarr(@RequestBody Usuarios usuarios) throws Exception {
		Usuarios obj = service.modificar(usuarios);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// ELIMINAR
	@DeleteMapping("/1/{id}")
	public ResponseEntity<Void> eliminarr(@PathVariable("id") Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// RICH NIVEL 2 / MODELO / HEADERS

	// LISTAR
	@GetMapping("/2")
	public ResponseEntity<List<Usuarios>> listar2() throws Exception {
		List<Usuarios> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// LISTARPORID
	@GetMapping("/2/{id}")
	public ResponseEntity<Usuarios> listarporId2(@PathVariable("id") Integer id) throws Exception {
		Usuarios obj = service.listarPorId(id);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// REGISTRAR
	@PostMapping("/2")
	public ResponseEntity<Void> registrar2(@RequestBody Usuarios usu) throws Exception {
		Usuarios obj = service.registrar(usu);
		
		//ACCESO AL RECURSO :8080/usuarios/2/1
		URI locattion = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdUsuario())
				.toUri();
		
		//return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
		return ResponseEntity.created(locattion).build();
	}

	// MODIFICAR
	@PutMapping("/2")
	public ResponseEntity<Usuarios> modificar2(@RequestBody Usuarios usuarios) throws Exception {
		Usuarios obj = service.modificar(usuarios);
		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// ELIMINAR
	@DeleteMapping("/2/{id}")
	public ResponseEntity<Void> eliminar2(@PathVariable("id") Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// LISTAR
	/*
	 * @GetMapping public ResponseEntity<List<Usuarios>> listarr()throws Exception{
	 * List<Usuarios> lista = service.listar().stream().map(p ->
	 * mapper.map(p,Usuarios.class)) .collect(Collectors.toList());
	 * 
	 * return new ResponseEntity<> (lista,HttpStatus.OK); }
	 */

	// LISTAR MODELO
	/*
	 * @GetMapping public List<Usuarios> listarUsuariosDTOs() throws Exception{
	 * List<Usuarios> usuarios = service.listar();
	 * 
	 * List<Usuarios> usuariosDTOs = usuarios.stream() .map(usu -> mapper.map(usu,
	 * Usuarios.class)) .collect(Collectors.toList()); return usuariosDTOs; }
	 */

}
