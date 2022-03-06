package com.cristiano.votacao.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.SessaoDto;
import com.cristiano.votacao.dto.input.SessaoInput;
import com.cristiano.votacao.model.Sessao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SessaoAssembler {

	private ModelMapper modelMapper;
	
	public SessaoDto toDto(Sessao sessao) {
		return modelMapper.map(sessao, SessaoDto.class);
	}
	
	public Sessao toEntity(SessaoInput sessaoInput) {
		return modelMapper.map(sessaoInput, Sessao.class);
	}
	
	public List<SessaoDto> toListSessaoDTO(List<Sessao> sessoes){
		return sessoes.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
}
