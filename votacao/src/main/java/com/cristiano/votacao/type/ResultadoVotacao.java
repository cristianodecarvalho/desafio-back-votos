package com.cristiano.votacao.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoVotacao {
	
	private int votosAFavor = 0;
	
	private int votosContra = 0;
	
	
	public void incrementarVotosAFavor() {
		votosAFavor++;
	}
	
	public void incrementarVotosContra() {
		votosContra++;
	}
	
}
