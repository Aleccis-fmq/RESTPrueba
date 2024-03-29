package edu.com.controller;

//paquetes de hateoas
//METODOS ESTATICOS PARA NO REDUNDAR
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import edu.com.exeption.ModeloNoFound;
import edu.com.model.Usuarios;
import edu.com.service.IUsuariosService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
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
	@GetMapping("/0/{id}")
	public Usuarios listarporId(@PathVariable("id") Integer id) throws Exception {
		return service.listarPorId(id);
	}

	// REGISTRAR
	@PostMapping("/0")
	public Usuarios registrar(@RequestBody Usuarios usu) throws Exception {
		return service.registrar(usu);
	}

	// MODIFICAR
	@PutMapping("/0")
	public Usuarios modificar(@RequestBody Usuarios usuarios) throws Exception {
		return service.modificar(usuarios);
	}

	// ELIMINAR
	@DeleteMapping("/0/{id}")
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

	// REGISTRAR /2.5
	@PostMapping("/2")
	public ResponseEntity<Void> registrar2(@RequestBody Usuarios usu) throws Exception {
		Usuarios obj = service.registrar(usu);

		// ACCESO AL RECURSO :8080/usuarios/2/1
		URI locattion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdUsuario()).toUri();

		// return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
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

	// RICH NIVEL 2 / DTO / HEADERS

	// LISTAR
	@GetMapping("/3")
	public ResponseEntity<List<UsuariosDTO>> listar3() throws Exception {
		List<UsuariosDTO> lista = service.listar().stream().map(p -> mapper.map(p, UsuariosDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// LISTARPORID
	@GetMapping("/3/{id}")
	public ResponseEntity<UsuariosDTO> listarporId3(@PathVariable("id") Integer id) throws Exception {
		Usuarios obj = service.listarPorId(id);
		UsuariosDTO dto = mapper.map(obj, UsuariosDTO.class);

		return new ResponseEntity<UsuariosDTO>(dto, HttpStatus.OK);
	}

	// REGISTRAR /2.5
	@PostMapping("/3")
	public ResponseEntity<Void> registrar3(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {
		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.registrar(usu);

		// ACCESO AL RECURSO :8080/usuarios/2/1
		URI locattion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdUsuario()).toUri();

		// return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
		return ResponseEntity.created(locattion).build();
	}

	// MODIFICAR
	@PutMapping("/3")
	public ResponseEntity<Usuarios> modificar3(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {
		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.modificar(usu);

		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// ELIMINAR
	// no hace uso de dtos
	@DeleteMapping("/3/{id}")
	public ResponseEntity<Void> eliminar3(@PathVariable("id") Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// RICH NIVEL 3 / DTO / HEADERS /exception

	// LISTAR
	@GetMapping("/4")
	public ResponseEntity<List<UsuariosDTO>> listar4() throws Exception {
		List<UsuariosDTO> lista = service.listar().stream().map(p -> mapper.map(p, UsuariosDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	// LISTARPORID
	@GetMapping("/4/{id}")
	public ResponseEntity<UsuariosDTO> listarporId4(@PathVariable("id") Integer id) throws Exception {
		Usuarios obj = service.listarPorId(id);

		// exception
		if (obj == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + id);
		}

		UsuariosDTO dto = mapper.map(obj, UsuariosDTO.class);

		return new ResponseEntity<UsuariosDTO>(dto, HttpStatus.OK);
	}

	// REGISTRAR /2.5
	@PostMapping("/4")
	public ResponseEntity<Void> registrar4(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {
		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.registrar(usu);

		// ACCESO AL RECURSO :8080/usuarios/2/1
		URI locattion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdUsuario()).toUri();

		// return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
		return ResponseEntity.created(locattion).build();
	}

	// MODIFICAR
	@PutMapping("/4")
	public ResponseEntity<Usuarios> modificar4(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {

		// exception2
		Usuarios usus = service.listarPorId(dtoRequest.getIdUsuario());

		//
		if (usus == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + dtoRequest.getIdUsuario());
		}

		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.modificar(usu);

		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// ELIMINAR

	// no hace uso de dtos
	@DeleteMapping("/4/{id}")
	public ResponseEntity<Void> eliminar4(@PathVariable("id") Integer id) throws Exception {

		Usuarios obj = service.listarPorId(id);

		//
		if (obj == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + id);
		}

		//
		service.eliminar(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// RICH NIVEL 3 / DTO / HEADERS /exception/HATEOAS

	// LISTAR
	@GetMapping("/5")
	public CollectionModel<EntityModel<UsuariosDTO>> listar5() throws Exception {
	    List<Usuarios> lista = service.listar();

	    if (lista.isEmpty()) {
	        // Manejo cuando la lista está vacía
	    }

	    List<EntityModel<UsuariosDTO>> usuariosDTO = lista.stream()
	    		.map(usuario -> {
	        UsuariosDTO dto = mapper.map(usuario, UsuariosDTO.class);

	        WebMvcLinkBuilder link = null;
			try {
				link = linkTo(methodOn(this.getClass()).listarporId5(usuario.getIdUsuario()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        EntityModel<UsuariosDTO> recurso = EntityModel.of(dto, link.withRel("usuario-info"));

	        return recurso;
	    }).collect(Collectors.toList());

	    WebMvcLinkBuilder linkTodos = linkTo(methodOn(this.getClass()).listar5());
	    CollectionModel<EntityModel<UsuariosDTO>> recursos = CollectionModel.of(usuariosDTO,
	            linkTodos.withRel("Todos-los-Usuarios"));

	    return recursos;
	}

	// LISTARPORID
	@GetMapping("/5/{id}")
	public EntityModel<UsuariosDTO> listarporId5(@PathVariable("id") Integer id) throws Exception {
		Usuarios obj = service.listarPorId(id);

		// exception
		if (obj == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + id);
		}

		UsuariosDTO dto = mapper.map(obj, UsuariosDTO.class);

		// proceso hateos creacion href

		EntityModel<UsuariosDTO> recurso = EntityModel.of(dto);

		// http://localhost:8080/api/usuarios/5/1
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarporId5(id));
		recurso.add(link1.withRel("usuario-info"));

		return recurso;
	}

	// REGISTRAR /2.5
	@PostMapping("/5")
	public ResponseEntity<Void> registrar5(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {
		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.registrar(usu);

		// ACCESO AL RECURSO :8080/usuarios/2/1
		URI locattion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdUsuario()).toUri();

		// return new ResponseEntity<Usuarios>(obj, HttpStatus.CREATED);
		return ResponseEntity.created(locattion).build();
	}

	// MODIFICAR
	@PutMapping("/5")
	public ResponseEntity<Usuarios> modificar5(@Valid @RequestBody UsuariosDTO dtoRequest) throws Exception {

		// exception2
		Usuarios usus = service.listarPorId(dtoRequest.getIdUsuario());

		//
		if (usus == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + dtoRequest.getIdUsuario());
		}

		Usuarios usu = mapper.map(dtoRequest, Usuarios.class);
		Usuarios obj = service.modificar(usu);

		return new ResponseEntity<Usuarios>(obj, HttpStatus.OK);
	}

	// ELIMINAR

	// no hace uso de dtos
	@DeleteMapping("/5/{id}")
	public ResponseEntity<Void> eliminar5(@PathVariable("id") Integer id) throws Exception {

		Usuarios obj = service.listarPorId(id);

		//
		if (obj == null) {
			throw new ModeloNoFound("NO EXISTE ESE ID : " + id);
		}

		//
		service.eliminar(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	//HATEOAS 6
	@GetMapping("/6")
	public CollectionModel<EntityModel<UsuariosDTO>> listar6() throws Exception {
	    List<Usuarios> lista = service.listar();

	    if (lista.isEmpty()) {
	      
	    	return CollectionModel.of(Collections.emptyList());
	    }

	    WebMvcLinkBuilder linkBase = linkTo(methodOn(this.getClass()).listar5());
	    List<EntityModel<UsuariosDTO>> usuariosDTO = lista.stream()
	        .map(usuario -> {
	            UsuariosDTO dto = mapper.map(usuario, UsuariosDTO.class);
	            WebMvcLinkBuilder linkUsuario = crearLinkUsuario(usuario.getIdUsuario());
	            EntityModel<UsuariosDTO> recurso = EntityModel.of(dto, linkUsuario.withRel("usuario-info"));
	            return recurso;
	        })
	        .collect(Collectors.toList());

	    CollectionModel<EntityModel<UsuariosDTO>> recursos = CollectionModel.of(usuariosDTO,
	            linkBase.withRel("Todos-los-Usuarios"));

	    return recursos;
	}

	@GetMapping("/6/{id}")
	public EntityModel<UsuariosDTO> listarporId6(@PathVariable("id") Integer id) throws Exception {
	    Usuarios obj = service.listarPorId(id);

	    if (obj == null) {
	        throw new ModeloNoFound("NO EXISTE ESE ID : " + id);
	    }

	    UsuariosDTO dto = mapper.map(obj, UsuariosDTO.class);
	    WebMvcLinkBuilder linkUsuario = crearLinkUsuario(obj.getIdUsuario());
	    EntityModel<UsuariosDTO> recurso = EntityModel.of(dto, linkUsuario.withRel("usuario-info"));

	    return recurso;
	}

	private WebMvcLinkBuilder crearLinkUsuario(Integer idUsuario) {
	    try {
	        return linkTo(methodOn(this.getClass()).listarporId6(idUsuario));
	    } catch (Exception e) {
	        // Manejo de la excepción según tus necesidades
	        return null; // O podrías devolver un enlace alternativo en caso de error
	    }
	}


}
