package com.cristiano.votacao.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDto criarUsuario(@Valid @RequestBody UsuarioInput usuarioInput) {
		return usuarioService.criarUsuario(usuarioInput);
	}

}
