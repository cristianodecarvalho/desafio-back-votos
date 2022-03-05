package com.cristiano.votacao.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaDto {

	private Long id;
	private String nome;
	private List<VotoDto> votos;
	
}
