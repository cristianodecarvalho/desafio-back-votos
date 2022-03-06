package com.cristiano.votacao.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoVotacao {
	
	private int contadorSim = 0;
	
	private int contadorNao = 0;
	
	
	public void incrementarContadorSim() {
		contadorSim++;
	}
	
	public void incrementarContadorNao() {
		contadorNao++;
	}
	
}
