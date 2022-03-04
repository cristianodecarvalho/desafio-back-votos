package com.cristiano.votacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.VotoRepository;

@Service
public class VotoService {
	
	private VotoRepository votoRepository;
	
	public VotoService(VotoRepository votoRepository) {
		this.votoRepository = votoRepository;
	}
	
	public List<Voto> listarVotos(Long pautaId){
		return votoRepository.findByPautaId(pautaId);
	}
	
	public Voto votar(Voto voto){
		return votoRepository.save(voto);
	}
	
}
