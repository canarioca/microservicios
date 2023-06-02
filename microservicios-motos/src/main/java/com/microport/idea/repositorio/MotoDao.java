package com.microport.idea.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microport.idea.entidades.Motos;

@Repository
public interface MotoDao extends JpaRepository<Motos, Integer> {

	List<Motos> findByUsuarioId( int usuarioId );
	
}