package com.cristiano.votacao.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.dto.input.PautaInput;
import com.cristiano.votacao.model.Pauta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PautaAssembler {

	private ModelMapper modelMapper;

	public PautaDto toDto(Pauta pauta) {
		return modelMapper.map(pauta, PautaDto.class);
	}

	public Pauta toEntity(PautaInput pautaInput) {
		return modelMapper.map(pautaInput, Pauta.class);
	}
	
	public List<PautaDto> toListPautaDTO(List<Pauta> pautas){
		return pautas.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
	
}
