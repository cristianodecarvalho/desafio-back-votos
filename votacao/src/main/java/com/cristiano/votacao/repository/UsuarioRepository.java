package com.cristiano.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.votacao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
