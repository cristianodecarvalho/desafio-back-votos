package com.cristiano.votacao.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.cristiano.votacao.dto.PautaDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "set")
public class SessaoInput {
	
	@Valid
	@NotBlank
	private PautaDto pauta;
	
	private Long duracao;

}
