package com.cristiano.votacao.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessaoIdInput {
	
	@NotBlank
	private Long id;
	
}
