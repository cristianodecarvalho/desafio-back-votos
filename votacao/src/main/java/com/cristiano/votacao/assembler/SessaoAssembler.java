package com.cristiano.votacao.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.SessaoDto;
import com.cristiano.votacao.model.Sessao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SessaoAssembler {

	private ModelMapper modelMapper;
	
	public SessaoDto toDto(Sessao sessao) {
		return modelMapper.map(sessao, SessaoDto.class);
	}
	
	public Sessao toEntity(SessaoDto sessaoDto) {
		return modelMapper.map(sessaoDto, Sessao.class);
	}
}
