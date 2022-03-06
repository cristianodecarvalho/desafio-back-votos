package com.cristiano.votacao.service;

import static java.util.Objects.isNull;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.SessaoAssembler;
import com.cristiano.votacao.dto.PautaDto;
import com.cristiano.votacao.dto.SessaoDto;
import com.cristiano.votacao.dto.input.SessaoInput;
import com.cristiano.votacao.enums.SessaoStatusEnum;
import com.cristiano.votacao.model.Sessao;
import com.cristiano.votacao.repository.SessaoRepository;
import com.cristiano.votacao.type.ResultadoVotacao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SessaoService {
	
	private SessaoRepository sessaoRepository;
	private SessaoAssembler sessaoAssembler;
	private PautaService pautaService;
	
	public List<SessaoDto> listarSessoes(){
		return sessaoAssembler.toListSessaoDTO(sessaoRepository.findAll());
	}
	
	@Transactional
	public SessaoDto abrirSessao(Long pautaId, Long duracao){
		PautaDto pauta = pautaService.encontrarPauta(pautaId);
		if(isNull(pauta)) {
			throw new RuntimeException("A pauta não existe!");
		}
		SessaoInput sessaoInput = SessaoInput.builder().setPauta(pauta).setDuracao(duracao).build();
		Sessao sessao =  sessaoRepository.save(sessaoAssembler.toEntity(sessaoInput));
		sessao.abrirSessao();
		return sessaoAssembler.toDto(sessaoRepository.save(sessao));
	}
	
	public SessaoStatusEnum obterStatusSessao(Long pautaId) {
		Sessao sessao =  sessaoRepository.findByPautaId(pautaId);
		if(isNull(sessao)) {
			return SessaoStatusEnum.INEXISTENTE;
		}
		return sessao.obterStatusSessao();
	}
	
	public ResultadoVotacao apurarVotos(Long pautaId){
		return pautaService.apurarVotos(pautaId);
	}
	
}
