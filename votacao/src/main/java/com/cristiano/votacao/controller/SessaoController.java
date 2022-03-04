package com.cristiano.votacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.model.Sessao;
import com.cristiano.votacao.service.SessaoService;

@RestController
@RequestMapping("sessoes")
public class SessaoController {

	private SessaoService sessaoService;
	
	public SessaoController(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}
	
	@PostMapping
	public ResponseEntity<Sessao> criarSessao(@RequestBody Sessao sessao){
		return ResponseEntity.ok(sessaoService.criarSessao(sessao));
	}
	
}
