package com.cristiano.votacao.dto.input;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;
	
}
