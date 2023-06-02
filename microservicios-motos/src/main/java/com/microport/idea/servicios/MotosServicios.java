package com.microport.idea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microport.idea.entidades.Motos;
import com.microport.idea.repositorio.MotoDao;


@Service
public class MotosServicios {

	@Autowired
	private MotoDao motossDao;
	
	public List<Motos> getAll(){
		return motossDao.findAll();
	}

	public Motos getMotosById( int id ) {
		return motossDao.findById( id ).orElse( null );
	}
	
	public Motos guardar( Motos motos ) {
		Motos nuevoCoche = motossDao.save( motos );
		return nuevoCoche;
	}
	
	public List<Motos> findByUsuarioId( int idUsuario ){
		return motossDao.findByUsuarioId(idUsuario);
	}
}
