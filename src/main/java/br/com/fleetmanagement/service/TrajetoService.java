package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fleetmanagement.DTO.TrajetoDTO;
import br.com.fleetmanagement.entity.Trajeto;
import br.com.fleetmanagement.repository.TrajetoRepository;

@Service
public class TrajetoService {
	
	@Autowired
	private TrajetoRepository trajetoRepository;
	
	public List<TrajetoDTO> findAll(){
		List<Trajeto> result = trajetoRepository.findAll();
		return result.stream().map(x -> new TrajetoDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
    public String obterGeoJSON() {
        return trajetoRepository.getGeoJSON();
    };

}
