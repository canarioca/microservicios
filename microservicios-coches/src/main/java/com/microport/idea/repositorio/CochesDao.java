package com.microport.idea.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microport.idea.coches.Coches;

@Repository
public interface CochesDao extends JpaRepository<Coches, Integer> {

	List<Coches> findByUsuarioId( int usuarioId );
	
}
