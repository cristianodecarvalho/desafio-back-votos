package com.cristiano.votacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessaoDto {

	private Long id;
	private PautaDto pauta;
	private Long duracao = 1L;
	
}
