package com.cristiano.votacao.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.UsuarioDto;
import com.cristiano.votacao.model.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsuarioAssembler {
	
	private ModelMapper modelMapper;
	
	public UsuarioDto toDto(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioDto.class);
	}
	
	public Usuario toEntity(UsuarioDto usuarioDto) {
		return modelMapper.map(usuarioDto, Usuario.class);
	}
	
}
