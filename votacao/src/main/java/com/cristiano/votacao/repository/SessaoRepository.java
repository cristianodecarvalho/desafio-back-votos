package com.cristiano.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.votacao.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{
	
	Sessao findByPautaId(Long pautaId);
	
}
