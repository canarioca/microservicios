package com.example.demo.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Usuarios;
import com.example.demo.modelos.Coches;
import com.example.demo.modelos.Motos;
import com.example.demo.servicio.UsuariosServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	UsuariosServicio usuarioServicio;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> listaUsuarios(){
		
		List<Usuarios> listUsuarios = usuarioServicio.getAll();
		
		if( listUsuarios.isEmpty() ) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok( listUsuarios );
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Usuarios> obtenerUsuario( @PathVariable int id ){
		
		Usuarios usuarios = usuarioServicio.getUsuariosById( id );
		
		if( usuarios == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( usuarios );
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> guardarUsuario( @RequestBody Usuarios usuario ){
		
		Usuarios usuarios = usuarioServicio.guardar( usuario );
		return ResponseEntity.ok( usuarios );
	}
	
	@GetMapping( "/coches/{usuarioId}" )
	public ResponseEntity<List<Coches>> listarCoches( @PathVariable("usuarioId") int id ){
		
		Usuarios usuarios = usuarioServicio.getUsuariosById( id );
		
		if( usuarios == null ) {
			return ResponseEntity.notFound().build();
		}
		
		List<Coches> lista = usuarioServicio.getCoches(id);
		
		return ResponseEntity.ok( lista );
	}
	
	@GetMapping( "/motos/{usuarioId}" )
	public ResponseEntity<List<Motos>> listarMotos( @PathVariable("usuarioId") int id ){
		
		Usuarios usuarios = usuarioServicio.getUsuariosById( id );
		
		if( usuarios == null ) {
			return ResponseEntity.notFound().build();
		}
		
		List<Motos> lista = usuarioServicio.getMotos(id);
		
		return ResponseEntity.ok( lista );
	}
	
	@PostMapping( "/coches/{usuarioId}" )
	public ResponseEntity<Coches> guardarCoche( @PathVariable("usuarioId") int usuarioId, @RequestBody Coches coches  ){
		
		Coches nuevoCoche = usuarioServicio.guardarCoche(usuarioId, coches); 
		
		return ResponseEntity.ok( nuevoCoche );
	}
	
	@PostMapping( "/motos/{usuarioId}" )
	public ResponseEntity<Motos> guardarMoto( @PathVariable("usuarioId") int usuarioId, @RequestBody Motos moto  ){
		
		Motos nuevaMoto = usuarioServicio.guardarMoto(usuarioId, moto); 
		
		return ResponseEntity.ok( nuevaMoto );
	}
	
	@GetMapping( "/todos/{usuarioId}" )
	public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos( @PathVariable("usuarioId") int id ){
		
		Map<String, Object> resultado = usuarioServicio.getUsuariosYVehiculos(id);
		return ResponseEntity.ok( resultado );
	}
} 
