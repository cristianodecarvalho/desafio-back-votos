package com.cristiano.votacao.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.model.Pauta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PautaAssembler {

	private ModelMapper modelMapper;

	public PautaDto toDto(Pauta pauta) {
		return modelMapper.map(pauta, PautaDto.class);
	}

	public Pauta toEntity(PautaDto pautaDto) {
		return modelMapper.map(pautaDto, Pauta.class);
	}
}
