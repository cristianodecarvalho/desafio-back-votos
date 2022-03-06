package com.cristiano.votacao.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.UsuarioAssembler;
import com.cristiano.votacao.dto.UsuarioDto;
import com.cristiano.votacao.dto.input.UsuarioInput;
import com.cristiano.votacao.model.Usuario;
import com.cristiano.votacao.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioAssembler usuarioAssembler;
	
	public UsuarioDto criarUsuario(UsuarioInput usuarioInput) {
		return usuarioAssembler.toDto(usuarioRepository.save(usuarioAssembler.toEntity(usuarioInput)));
	}
	
	public UsuarioDto encontrarUsuario(Long id) {
		Optional<Usuario> usuario =  usuarioRepository.findById(id);
		if(!usuario.isPresent()) {
			throw new RuntimeException("Usuário não existe!");
		}
		
		return usuarioAssembler.toDto(usuario.get());
	}
	
}