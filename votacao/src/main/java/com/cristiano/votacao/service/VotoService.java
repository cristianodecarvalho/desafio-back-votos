package com.cristiano.votacao.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cristiano.votacao.assembler.UsuarioAssembler;
import com.cristiano.votacao.assembler.VotoAssembler;
import com.cristiano.votacao.dto.VotoDto;
import com.cristiano.votacao.dto.input.VotoInput;
import com.cristiano.votacao.enums.CpfStatusEnum;
import com.cristiano.votacao.enums.SessaoStatusEnum;
import com.cristiano.votacao.exception.VotacaoException;
import com.cristiano.votacao.model.Usuario;
import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.VotoRepository;
import com.cristiano.votacao.type.CpfStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VotoService {
	
	private VotoRepository votoRepository;
	private VotoAssembler votoAssembler;
	private UsuarioService usuarioService;
	private PautaService pautaService;
	private SessaoService sessaoService;
	private UsuarioAssembler usuarioAssembler;
	
	@Transactional
	public VotoDto votar(VotoInput votoInput){
		Voto voto = votoAssembler.toEntity(votoInput);
		Long pautaId = votoInput.getPauta().getId();
		Long usuarioId = votoInput.getUsuario().getId();
		Usuario usuario = usuarioAssembler.toEntity(usuarioService.encontrarUsuario(usuarioId));
		voto.setUsuario(usuario);
		pautaService.encontrarPauta(pautaId);
		usuarioService.encontrarUsuario(usuarioId);
		validarCpf(usuario.getCpf());
		Voto votoEncontrado = votoRepository.findByPautaIdAndUsuarioId(pautaId, usuarioId);
		if(nonNull(votoEncontrado)) {
			throw new VotacaoException("Usuário já votou para essa pauta!");
		}
		SessaoStatusEnum status = sessaoService.obterStatusSessao(pautaId);
		if(status.equals(SessaoStatusEnum.INEXISTENTE) || status.equals(SessaoStatusEnum.NAO_INICIADA)) {
			throw new VotacaoException("Sessão não foi iniciada ou não existe!");	
		}else if(status.equals(SessaoStatusEnum.FINALIZADA)) {
			throw new VotacaoException("Sessão já foi finalizada!");	
		} 
		return votoAssembler.toDto(votoRepository.save(voto));
	}
	
	public List<VotoDto> listarVotos(Long pautaId){
		pautaService.encontrarPauta(pautaId);
		return votoAssembler.toListVotoDTO(votoRepository.findByPautaId(pautaId));
	}
	
	private void validarCpf(String cpf) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CpfStatus> cpfStatus = restTemplate.getForEntity("https://user-info.herokuapp.com/users/" + cpf, CpfStatus.class);
		CpfStatus body= Optional.of(cpfStatus.getBody()).orElseThrow(() -> new VotacaoException("Não foi possível validar o CPF"));
		if(CpfStatusEnum.valueOf(body.getStatus()).equals(CpfStatusEnum.UNABLE_TO_VOTE)) {
			throw new VotacaoException("Usuário não pode votar!");
		}
	}
	
}
