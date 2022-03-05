package com.cristiano.votacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.model.Pauta;
import com.cristiano.votacao.service.PautaService;

@RestController
@RequestMapping("pautas")
public class PautaController {
	
	private PautaService pautaService;
	
	public PautaController(PautaService pautaService) {
		this.pautaService = pautaService;
	}
	
	@PostMapping
	public ResponseEntity<PautaDto> criarPauta(@RequestBody Pauta pauta){
		return ResponseEntity.ok(pautaService.criarPauta(pauta));
	}
	
}
