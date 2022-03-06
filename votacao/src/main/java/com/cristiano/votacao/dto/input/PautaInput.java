package com.cristiano.votacao.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaInput {

	@NotBlank(message = "Nome da pauta é obrigatório")
	private String nome;
	
}
