package com.cristiano.votacao.dto.input;

import com.cristiano.votacao.enums.VotoStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoInput {

	private VotoStatusEnum status;
	private PautaIdInput pauta;
	private UsuarioIdInput usuario;
	
}
