package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fleetmanagement.DTO.ContratoDTO;
import br.com.fleetmanagement.entity.Contrato;
import br.com.fleetmanagement.projection.ContratoProjection;
import br.com.fleetmanagement.repository.ContratoRepository;

@Service
public class ContratoService {
		
	@Autowired
	private ContratoRepository contratoRepository;
	
	public List<ContratoDTO>  findAll(){
		List<Contrato> result = contratoRepository.findAll();
		return result.stream().map(x -> new ContratoDTO(x)).toList();
	}
	
	public List<ContratoDTO>  findByNumContrato(String num_Contrato){
		List<ContratoProjection> result = contratoRepository.searchByNumContrato(num_Contrato);
		return result.stream().map(x -> new ContratoDTO(x)).toList();
	}
}
