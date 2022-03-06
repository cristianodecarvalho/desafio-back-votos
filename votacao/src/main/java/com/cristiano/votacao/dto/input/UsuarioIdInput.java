package com.cristiano.votacao.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioIdInput {

	@NotBlank(message = "Id do usuário é obrigatório")
	private Long id;
	
}
