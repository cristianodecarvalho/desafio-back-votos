package com.cristiano.votacao.type;

public class ResultadoVotacao {
	
	private int contadorSim = 0;
	
	private int contadorNao = 0;
	
	
	public void incrementarContadorSim() {
		contadorSim++;
	}
	
	public void incrementarContadorNao() {
		contadorNao++;
	}

	public int getContadorSim() {
		return contadorSim;
	}

	public void setContadorSim(int contadorSim) {
		this.contadorSim = contadorSim;
	}

	public int getContadorNao() {
		return contadorNao;
	}

	public void setContadorNao(int contadorNao) {
		this.contadorNao = contadorNao;
	}
	
}
