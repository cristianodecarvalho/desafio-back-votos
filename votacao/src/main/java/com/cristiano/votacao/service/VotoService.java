package com.cristiano.votacao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.VotoAssembler;
import com.cristiano.votacao.dto.VotoDto;
import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.VotoRepository;

@Service
public class VotoService {
	
	private VotoRepository votoRepository;
	private VotoAssembler votoAssembler;
	
	public VotoService(VotoRepository votoRepository) {
		this.votoRepository = votoRepository;
	}
	
	public List<VotoDto> listarVotos(Long pautaId){
		return votoAssembler.toListVotoDTO(votoRepository.findByPautaId(pautaId));
	}
	
	@Transactional
	public VotoDto votar(Voto voto){
		return votoAssembler.toDto(votoRepository.save(voto));
	}
	
}
