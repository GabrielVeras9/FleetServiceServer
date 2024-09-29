package br.com.fleetmanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fleetmanagement.DTO.RotaTesteDTO;
import br.com.fleetmanagement.entity.RotaTeste;
import br.com.fleetmanagement.repository.RotaTesteRepository;

@Service
public class RotaTesteService {
	
	private final RotaTesteRepository rotaTesteRepository;

    @Autowired
    public RotaTesteService(RotaTesteRepository rotaTesteRepository) {
        this.rotaTesteRepository = rotaTesteRepository;
    }
	
	@Transactional(readOnly = true)
	public List<RotaTesteDTO> findAll(){
		List<RotaTeste> result = rotaTesteRepository.findAll();
		return result.stream().map(x -> new RotaTesteDTO(x)).toList();

	}

    @Transactional(readOnly = true)
    public String obterRotaGeoJSON() {
        return rotaTesteRepository.getRotaGeoJSON();
    };
    
    public void salvarRota(List<Map<String, Double>> routeData) {
        for (Map<String, Double> waypoint : routeData) {
            Double latitude = waypoint.get("lat");
            Double longitude = waypoint.get("lng");
            Double extensao = waypoint.get("extensao");
            Double tempoMedio = waypoint.get("tempoMedio");

            RotaTeste rotaTeste = new RotaTeste();
            rotaTeste.setLatitude(latitude);
            rotaTeste.setLongitude(longitude);
            rotaTeste.setExtensao(extensao);
            rotaTeste.setTempo_medio(tempoMedio);
            
            rotaTesteRepository.save(rotaTeste);
        }
    }
 }