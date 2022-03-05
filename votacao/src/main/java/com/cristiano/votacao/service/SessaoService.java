package com.cristiano.votacao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cristiano.votacao.assembler.SessaoAssembler;
import com.cristiano.votacao.dto.SessaoDto;
import com.cristiano.votacao.model.Sessao;
import com.cristiano.votacao.repository.SessaoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SessaoService {
	
	private SessaoRepository sessaoRepository;
	private SessaoAssembler sessaoAssembler;
	
	public SessaoDto criarSessao(@RequestBody Sessao sessao){
		return sessaoAssembler.toDto(sessaoRepository.save(sessao));
	}
	
}
