package com.cristiano.votacao.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cristiano.votacao.dto.VotoDto;
import com.cristiano.votacao.model.Voto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class VotoAssembler {

	private ModelMapper modelMapper;
	
	public VotoDto toDto(Voto voto) {
		return modelMapper.map(voto, VotoDto.class);
	}
	
	public Voto toEntity(VotoDto votoDto) {
		return modelMapper.map(votoDto, Voto.class);
	}
	
	public List<VotoDto> toListVotoDTO(List<Voto> votos){
		return votos.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
}
