package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fleetmanagement.DTO.OperadorDTO;
import br.com.fleetmanagement.entity.Operador;
import br.com.fleetmanagement.projection.OperadorProjection;
import br.com.fleetmanagement.repository.OperadorRepository;

@Service
public class OperadorService {

	@Autowired
	private OperadorRepository operadorRepository;
	
	public List<OperadorDTO> findAll(){
		List<Operador> result = operadorRepository.findAll();
		return result.stream().map(x -> new OperadorDTO(x)).toList();
	}

	public List<OperadorDTO> FindByCnpj(String cnpj_operador){
		List<OperadorProjection> result = operadorRepository.searchByCnpj(cnpj_operador);
		return result.stream().map(x -> new OperadorDTO(x)).toList();
	}
}

