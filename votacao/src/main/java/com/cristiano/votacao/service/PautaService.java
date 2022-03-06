package com.cristiano.votacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.PautaAssembler;
import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.dto.input.PautaInput;
import com.cristiano.votacao.enums.VotoStatusEnum;
import com.cristiano.votacao.exception.VotacaoException;
import com.cristiano.votacao.model.Pauta;
import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.PautaRepository;
import com.cristiano.votacao.type.ResultadoVotacao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PautaService {

	private PautaRepository pautaRepository;
	private PautaAssembler pautaAssembler;
	
	@Transactional
	public PautaDto criarPauta(PautaInput pautaInput){
		return pautaAssembler.toDto(pautaRepository.save(pautaAssembler.toEntity(pautaInput)));
	}
	
	public List<PautaDto> listarPautas(){
		return pautaAssembler.toListPautaDTO(pautaRepository.findAll());
	}
	
	public PautaDto encontrarPauta(Long id) {
		Optional<Pauta> pauta =  pautaRepository.findById(id);
		if(!pauta.isPresent()) {
			throw new VotacaoException("Pauta não existe!");
		}
		
		return pautaAssembler.toDto(pauta.get());
	}
	
	public ResultadoVotacao apurarVotos(Long pautaId){
		Optional<Pauta> pauta = pautaRepository.findById(pautaId);
		if(!pauta.isPresent()) {
			throw new VotacaoException("Pauta não existe!");
		}
		
		List<Voto> votos = pauta.get().getVotos();
		
		ResultadoVotacao resultado = new ResultadoVotacao();
		
		for(Voto voto : votos) {
			if(voto.getStatus() == VotoStatusEnum.SIM) {
				resultado.incrementarVotosAFavor();
			}else {
				resultado.incrementarVotosContra();
			}
		}
		
		return resultado;
	}
	
}
