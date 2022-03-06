package com.cristiano.votacao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.votacao.dto.UsuarioDto;
import com.cristiano.votacao.dto.input.UsuarioInput;
import com.cristiano.votacao.service.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioInput usuarioInput) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.criarUsuario(usuarioInput));
	}

}
