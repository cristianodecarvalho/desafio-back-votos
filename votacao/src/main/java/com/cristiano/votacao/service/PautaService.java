package com.cristiano.votacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cristiano.votacao.enums.VotoStatusEnum;
import com.cristiano.votacao.model.Pauta;
import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.PautaRepository;
import com.cristiano.votacao.type.ResultadoVotacao;

@Service
public class PautaService {

	public PautaRepository pautaRepository;
	
	public PautaService(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}
	
	public Pauta criarPauta(@RequestBody Pauta pauta){
		return pautaRepository.save(pauta);
	}
	
	public ResultadoVotacao obterResultado(Long pautaId){
		Optional<Pauta> pauta = pautaRepository.findById(pautaId);
		if(!pauta.isPresent()) {
			return null;
			//throw new Exception("Pauta inexistente");
		}
		
		List<Voto> votos = pauta.get().getVotos();
		
		ResultadoVotacao resultado = new ResultadoVotacao();
		
		for(Voto voto : votos) {
			if(voto.getStatus() == VotoStatusEnum.SIM) {
				resultado.incrementarContadorSim();
			}else {
				resultado.incrementarContadorNao();
			}
		}
		
		return resultado;
		
	}
	
}
