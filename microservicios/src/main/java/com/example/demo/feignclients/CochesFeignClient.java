package com.example.demo.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Coches;

@FeignClient( name = "cochesServicio", url = "http://localhost:8091" )
@RequestMapping("/coches")
public interface CochesFeignClient {
	
	@PostMapping
	public Coches guardar( @RequestBody Coches coches );
	
	@GetMapping( "/usuarios/{usuarioId}" )
	public List<Coches> getCoches( @PathVariable("usuarioId") int usuarioId );
	
}
