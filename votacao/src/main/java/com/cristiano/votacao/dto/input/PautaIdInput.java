package com.cristiano.votacao.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaIdInput {

	@NotBlank(message = "Id da pauta é obrigatório")
	private Long id;
	
}
