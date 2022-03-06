package com.cristiano.votacao.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.cristiano.votacao.enums.VotoStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoInput {

	@NotBlank
	private VotoStatusEnum status;
	
	@Valid
	@NotBlank
	private PautaIdInput pauta;
	
	@Valid
	@NotBlank
	private UsuarioIdInput usuario;
	
}
