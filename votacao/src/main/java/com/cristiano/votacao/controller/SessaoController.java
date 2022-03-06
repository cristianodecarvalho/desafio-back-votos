package com.cristiano.votacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.SessaoDto;
import com.cristiano.votacao.exception.VotacaoException;
import com.cristiano.votacao.service.SessaoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("sessoes")
public class SessaoController {

	private SessaoService sessaoService;
	
	@GetMapping()
	public ResponseEntity<List<SessaoDto>> listarSessoes(){
		return ResponseEntity.status(HttpStatus.OK).body(sessaoService.listarSessoes());
	}
	
	@GetMapping("apurar/{pautaId}")
	public ResponseEntity<?> apurarVotos(@PathVariable Long pautaId){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(sessaoService.apurarVotos(pautaId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		 
	}
	
	@PatchMapping("abrir/{pautaId}")
	public ResponseEntity<?> abrirSessao(@PathVariable Long pautaId, @RequestParam(defaultValue = "1", required = false) Long duracao){
		try {
			if(duracao < 1) {
				throw new VotacaoException("Duração deve ser maior igual a 1");	
			}
			return ResponseEntity.status(HttpStatus.OK).body(sessaoService.abrirSessao(pautaId, duracao));		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	
	}
	
}
