package com.example.demo.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidades.Usuarios;
import com.example.demo.feignclients.CochesFeignClient;
import com.example.demo.feignclients.MotosFeignClient;
import com.example.demo.modelos.Coches;
import com.example.demo.modelos.Motos;
import com.example.demo.repositorio.UsuarioDao;

@Service
public class UsuariosServicio {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CochesFeignClient cochesFeignClient;
	
	@Autowired
	private MotosFeignClient motosFeignClient;
	
	@Autowired
	private UsuarioDao usuarioDao;

	public List<Usuarios> getAll(){
		return usuarioDao.findAll();
	}

	public Usuarios getUsuariosById( int id ) {
		return usuarioDao.findById( id ).orElse( null );
	}
	
	public Usuarios guardar( Usuarios usuario ) {
		
		Usuarios nuevoUsuario = usuarioDao.save( usuario );
		return nuevoUsuario;
	}
	
	////// REST TEMPLATE 
	public List<Coches> getCoches( int usuarioId ){
		List<Coches> coches = restTemplate.getForObject( "http://localhost:8091/coches/usuarios/" + usuarioId, List.class);
		return coches;
	}
	
	public List<Motos> getMotos( int usuarioId ){
		List<Motos> motos = restTemplate.getForObject( "http://localhost:8092/motos/usuarios/" + usuarioId, List.class);
		return motos;
	}
	
	/////// FEIGN CLIENT
	public Coches guardarCoche( int usuarioId, Coches coches ) {
		
		coches.setUsuarioId(usuarioId);
		Coches nuevoCoche = cochesFeignClient.guardar( coches );
		
		return nuevoCoche;
	}
	
	public Motos guardarMoto( int usuarioId, Motos moto ) {
		
		moto.setUsuarioId(usuarioId);
		Motos nuevoMoto = motosFeignClient.guardar( moto );
		
		return nuevoMoto;
	}
	
	public Map<String, Object> getUsuariosYVehiculos( int usuarioId ){
		
		Map<String, Object> resultado = new HashMap<>();
		Usuarios usuario = usuarioDao.findById( usuarioId ).orElse(null);
		
		if( usuario == null ) {
			resultado.put( "Mensaje", "Usuario no existe");
			return resultado;
		}
		
		resultado.put( "Usuario", usuario);
		List<Coches> coches = cochesFeignClient.getCoches(usuarioId);
		
		if( coches.isEmpty() ) {
			resultado.put( "Coches", "Usuario no tienes coches");
		}
		else {
			resultado.put( "Coches", coches);
		}
		
		List<Motos> motos = motosFeignClient.getMotos(usuarioId);
		
		if( coches.isEmpty() ) {
			resultado.put( "Motos", "Usuario no tienes motos");
		}
		else {
			resultado.put( "Motos", motos);
		}
		
		return resultado;
	}
	
}
