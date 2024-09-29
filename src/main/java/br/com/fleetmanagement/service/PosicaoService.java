package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fleetmanagement.DTO.PosicaoDTO;
import br.com.fleetmanagement.entity.Posicao;
import br.com.fleetmanagement.projection.PosicaoPrejection;
import br.com.fleetmanagement.repository.PosicaoRepository;

@Service
public class PosicaoService {
	
	@Autowired
	private PosicaoRepository posicaoRepository;
	
	public List<PosicaoDTO> findAll(){
		List<Posicao> result = posicaoRepository.findAll();
		return result.stream().map(x -> new PosicaoDTO(x)).toList();
	}
	
	public List<PosicaoDTO> findByPlaca(String placaveiculo){
		List<PosicaoPrejection> result = posicaoRepository.searchByPlaca(placaveiculo);
		return result.stream().map(x -> new PosicaoDTO(x)).toList();
	}
}
