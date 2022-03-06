package com.cristiano.votacao.dto.input;

import com.cristiano.votacao.dto.PautaDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "set")
public class SessaoInput {
	
	private PautaDto pauta;
	private Long duracao;

}
