package com.cristiano.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.votacao.model.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
