package com.cristiano.votacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.votacao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>{

	List<Voto> findByPautaId(Long pautaId);
	
	Voto findByPautaIdAndUsuarioId(Long pautaId, Long usuarioId);
	
}
