package com.cristiano.votacao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cristiano.votacao.model.Sessao;
import com.cristiano.votacao.repository.SessaoRepository;

@Service
public class SessaoService {
	
	private SessaoRepository sessaoRepository;
	
	public SessaoService(SessaoRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}
	
	public Sessao criarSessao(@RequestBody Sessao sessao){
		return sessaoRepository.save(sessao);
	}
	
}
