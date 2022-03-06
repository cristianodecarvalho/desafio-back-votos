package com.cristiano.votacao.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cristiano.votacao.enums.VotoStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoInput {

	@NotNull(message = "Você precisar informar o status do voto(SIM/NAO)")
	private VotoStatusEnum status;
	
	@Valid
	@NotNull
	private PautaIdInput pauta;
	
	@Valid
	@NotNull
	private UsuarioIdInput usuario;
	
}
