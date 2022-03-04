package com.cristiano.votacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.service.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

	private VotoService votoService;
	
	public VotoController(VotoService votoService) {
		this.votoService = votoService;
	}
	
	@PostMapping
	public ResponseEntity<Voto> votar(@RequestBody Voto voto){
		return ResponseEntity.ok(votoService.votar(voto));
	}
	
}
