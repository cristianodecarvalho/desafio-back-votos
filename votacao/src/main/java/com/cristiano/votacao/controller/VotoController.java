package com.cristiano.votacao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.input.VotoInput;
import com.cristiano.votacao.service.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

	private VotoService votoService;

	public VotoController(VotoService votoService) {
		this.votoService = votoService;
	}

	@PostMapping
	public ResponseEntity<Object> votar(@RequestBody VotoInput votoInput) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(votoService.votar(votoInput));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/pauta/{pautaId}")
	public ResponseEntity<?> listarVotos(@PathVariable Long pautaId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(votoService.listarVotos(pautaId));	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

}
