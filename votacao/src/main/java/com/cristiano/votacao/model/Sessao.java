package com.cristiano.votacao.model;

import static java.util.Objects.nonNull;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cristiano.votacao.enums.SessaoStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_SESSAO")
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="pauta_id")
	@NotBlank(message = "Pauta é obrigatória")
	private Pauta pauta;
	
	@Size(min = 1, message = "Duração miníma de 1 minuto.")
	private Long duracao;
	private OffsetDateTime  dataInicio;
	private OffsetDateTime  dataFim;	
	
	public void abrirSessao() {
		if(nonNull(dataInicio)) {
			throw new RuntimeException("Sessão já foi aberta!");
		}else {
			setDataInicio(OffsetDateTime.now());
			setDataFim(OffsetDateTime.now().plusMinutes(duracao));
		}
	}
	
	public SessaoStatusEnum obterStatusSessao() {
		if( !nonNull(dataInicio) || !nonNull(dataFim) || OffsetDateTime.now().isBefore(dataInicio)) {
			return SessaoStatusEnum.NAO_INICIADA;
		}else if(OffsetDateTime.now().isAfter(dataFim)) {
			return SessaoStatusEnum.FINALIZADA;
		}
		return SessaoStatusEnum.ABERTA;
	}

}
