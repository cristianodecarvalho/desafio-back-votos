package com.cristiano.votacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.VotoDto;
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
	public ResponseEntity<Object> votar(@RequestBody Voto voto) {
		try {
			var votoComputado = votoService.votar(voto);
			return ResponseEntity.status(HttpStatus.OK).body(votoComputado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro ao votar");
		}
	}

	@GetMapping("/pauta/{pautaId}")
	public ResponseEntity<List<VotoDto>> votar(@PathVariable Long pautaId) {
		List<VotoDto> votos = votoService.listarVotos(pautaId);
		return ResponseEntity.status(HttpStatus.OK).body(votos);
	}

}
