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

	import com.microport.idea.entidades.Motos;
	import com.microport.idea.servicios.MotosServicios;


@RestController
@RequestMapping( "/motos" )
public class MotosControlador {

	@Autowired
	private MotosServicios motosServicio;
	
	@GetMapping
	public ResponseEntity<List<Motos>> listaMotos(){
		
		List<Motos> listMotos = motosServicio.getAll();
		
		if( listMotos.isEmpty() ) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok( listMotos );
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Motos> obtenerCoche( @PathVariable int id ){
		
		Motos usuarios = motosServicio.getMotosById( id );
		
		if( usuarios == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( usuarios );
	}
	
	@PostMapping
	public ResponseEntity<Motos> guardarCoche( @RequestBody Motos usuario ){
		
		Motos usuarios = motosServicio.guardar( usuario );
		return ResponseEntity.ok( usuarios );
	}
	
	
	@GetMapping( "/usuarios/{usuarioId}" )
	public ResponseEntity<List<Motos>> obtenerListaPorUsuarioId( @PathVariable("usuarioId") int idUsuario ){
		
		List<Motos> listMotos = motosServicio.findByUsuarioId( idUsuario );
		
		if( listMotos == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok( listMotos );
	}

}
