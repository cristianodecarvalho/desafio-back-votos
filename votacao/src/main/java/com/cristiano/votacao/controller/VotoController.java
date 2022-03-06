package com.cristiano.votacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.VotoDto;
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
	@ResponseStatus(HttpStatus.CREATED)
	public VotoDto votar(@Valid @RequestBody VotoInput votoInput) {
		return votoService.votar(votoInput);
	}

	@GetMapping("/pauta/{pautaId}")
	public List<VotoDto> listarVotos(@PathVariable Long pautaId) {
		return votoService.listarVotos(pautaId);	
	}

}
