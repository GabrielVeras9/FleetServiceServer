package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fleetmanagement.DTO.ServicoDTO;
import br.com.fleetmanagement.entity.Servico;
import br.com.fleetmanagement.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<ServicoDTO> findAll(){
	List<Servico> result = servicoRepository.findAll();
	return result.stream().map(x -> new ServicoDTO(x)).toList();
	}
}
