package com.cristiano.votacao.service;

import static java.util.Objects.nonNull;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cristiano.votacao.assembler.UsuarioAssembler;
import com.cristiano.votacao.assembler.VotoAssembler;
import com.cristiano.votacao.dto.VotoDto;
import com.cristiano.votacao.dto.input.VotoInput;
import com.cristiano.votacao.enums.SessaoStatusEnum;
import com.cristiano.votacao.model.Usuario;
import com.cristiano.votacao.model.Voto;
import com.cristiano.votacao.repository.VotoRepository;

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
	
	public List<VotoDto> listarVotos(Long pautaId){
		pautaService.encontrarPauta(pautaId);
		return votoAssembler.toListVotoDTO(votoRepository.findByPautaId(pautaId));
	}
	
	@Transactional
	public VotoDto votar(VotoInput votoInput){
		Voto voto = votoAssembler.toEntity(votoInput);
		Long pautaId = votoInput.getPauta().getId();
		Long usuarioId = votoInput.getUsuario().getId();
		Usuario usuario = usuarioAssembler.toEntity(usuarioService.encontrarUsuario(usuarioId));
		voto.setUsuario(usuario);
		pautaService.encontrarPauta(pautaId);
		usuarioService.encontrarUsuario(usuarioId);
		Voto votoEncontrado = votoRepository.findByPautaIdAndUsuarioId(pautaId, usuarioId);
		if(nonNull(votoEncontrado)) {
			throw new RuntimeException("Usuário já votou para essa pauta!");
		}
		SessaoStatusEnum status = sessaoService.obterStatusSessao(pautaId);
		if(status.equals(SessaoStatusEnum.INEXISTENTE)) {
			throw new RuntimeException("A sesssão não existe!");	
		}else if(status.equals(SessaoStatusEnum.NAO_INICIADA)) {
			throw new RuntimeException("A sesssão ainda não foi iniciada!");	
		}else if(status.equals(SessaoStatusEnum.FINALIZADA)) {
			throw new RuntimeException("A sesssão já foi finalizada!");	
		} 
		return votoAssembler.toDto(votoRepository.save(voto));
	}
	
}
