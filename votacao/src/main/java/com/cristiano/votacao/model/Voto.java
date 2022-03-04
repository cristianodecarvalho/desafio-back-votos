package com.cristiano.votacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cristiano.votacao.enums.VotoStatusEnum;

@Entity
@Table(name = "TB_VOTO")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private VotoStatusEnum status;
	
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VotoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(VotoStatusEnum status) {
		this.status = status;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
