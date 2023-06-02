package com.example.demo.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Motos;

@FeignClient( name = "motosServicio", url = "http://localhost:8092" )
@RequestMapping("/motos")
public interface MotosFeignClient {

	@PostMapping
	public Motos guardar( @RequestBody Motos moto );
	
	@GetMapping( "/usuarios/{usuarioId}" )
	public List<Motos> getMotos( @PathVariable("usuarioId") int usuarioId );
	
}
