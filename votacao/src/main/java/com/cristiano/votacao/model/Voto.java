package com.cristiano.votacao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cristiano.votacao.enums.VotoStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_VOTO")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Você precisar informar o status do voto(SIM/NAO)")
	@Enumerated(EnumType.STRING)
	private VotoStatusEnum status;
	
	@NotNull(message = "Você precisar informar a pauta")
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;
	
	@NotNull(message = "Você precisar informar o usuário")
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
