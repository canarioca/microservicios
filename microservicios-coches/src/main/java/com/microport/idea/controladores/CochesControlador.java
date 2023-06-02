package com.microport.idea.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microport.idea.coches.Coches;
import com.microport.idea.servicios.CochesServicios;

@RestController
@RequestMapping( "/coches" )
public class CochesControlador {

	@Autowired
	private CochesServicios cochesServicio;
	
	@GetMapping
	public ResponseEntity<List<Coches>> listaCoches(){
		
		List<Coches> listCoches = cochesServicio.getAll();
		
		if( listCoches.isEmpty() ) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok( listCoches );
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Coches> obtenerCoche( @PathVariable int id ){
		
		Coches usuarios = cochesServicio.getCochesById( id );
		
		if( usuarios == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( usuarios );
	}
	
	@PostMapping
	public ResponseEntity<Coches> guardarCoche( @RequestBody Coches usuario ){
		
		Coches usuarios = cochesServicio.guardar( usuario );
		return ResponseEntity.ok( usuarios );
	}
	
	
	@GetMapping( "/usuarios/{usuarioId}" )
	public ResponseEntity<List<Coches>> obtenerListaPorUsuarioId( @PathVariable("usuarioId") int idUsuario ){
		
		List<Coches> listCoches = cochesServicio.findByUsuarioId( idUsuario );
		
		if( listCoches == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( listCoches );
	}
	
}
