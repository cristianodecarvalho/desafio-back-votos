package com.cristiano.votacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.dto.input.PautaInput;
import com.cristiano.votacao.service.PautaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("pautas")
public class PautaController {
	
	private PautaService pautaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PautaDto criarPauta(@Valid @RequestBody PautaInput pautaInput){
		return pautaService.criarPauta(pautaInput);
	}
	
	@GetMapping
	public ResponseEntity<List<PautaDto>> listarPautas(){
		return ResponseEntity.status(HttpStatus.OK).body(pautaService.listarPautas());
	}
	
}
