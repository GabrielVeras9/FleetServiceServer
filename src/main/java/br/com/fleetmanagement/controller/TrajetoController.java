package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.TrajetoDTO;
import br.com.fleetmanagement.service.TrajetoService;

@RestController
@RequestMapping(value = "/rota/trajeto")
public class TrajetoController {
	
	@Autowired
	private TrajetoService trajetoService;

	@GetMapping
	public List<TrajetoDTO> finAll(){
		List<TrajetoDTO> result = trajetoService.findAll();
		return result; 
	}
	
	@GetMapping("/geojson")
    public ResponseEntity<String> obterRotaGeoJSON() {
        String rotaGeoJSON = trajetoService.obterGeoJSON(); // Chama o serviço para obter o JSON da rota

        if (rotaGeoJSON != null) {
            return ResponseEntity.ok(rotaGeoJSON);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
