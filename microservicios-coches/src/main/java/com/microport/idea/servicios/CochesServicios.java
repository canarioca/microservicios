package com.microport.idea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microport.idea.coches.Coches;
import com.microport.idea.repositorio.CochesDao;

@Service
public class CochesServicios {

	@Autowired
	private CochesDao cochesDao;
	
	public List<Coches> getAll(){
		return cochesDao.findAll();
	}

	public Coches getCochesById( int id ) {
		return cochesDao.findById( id ).orElse( null );
	}
	
	public Coches guardar( Coches coche ) {
		Coches nuevoCoche = cochesDao.save( coche );
		return nuevoCoche;
	}
	
	public List<Coches> findByUsuarioId( int idUsuario ){
		
		return cochesDao.findByUsuarioId(idUsuario);
		
	}
}
