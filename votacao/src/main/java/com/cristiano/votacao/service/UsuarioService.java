package com.cristiano.votacao.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.UsuarioAssembler;
import com.cristiano.votacao.dto.UsuarioDto;
import com.cristiano.votacao.dto.input.UsuarioInput;
import com.cristiano.votacao.exception.VotacaoException;
import com.cristiano.votacao.model.Usuario;
import com.cristiano.votacao.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioAssembler usuarioAssembler;
	
	@Transactional
	public UsuarioDto criarUsuario(UsuarioInput usuarioInput) {
		return usuarioAssembler.toDto(usuarioRepository.save(usuarioAssembler.toEntity(usuarioInput)));
	}
	
	public UsuarioDto encontrarUsuario(Long id) {
		Optional<Usuario> usuario =  usuarioRepository.findById(id);
		if(!usuario.isPresent()) {
			throw new VotacaoException("Usuário não existe!");
		}
		return usuarioAssembler.toDto(usuario.get());
	}
	
}
