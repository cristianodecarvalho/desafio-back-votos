package com.cristiano.votacao.dto;

import com.cristiano.votacao.enums.VotoStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotoDto {

	private Long id;
	private VotoStatusEnum status;
	private UsuarioDto usuario;
}
