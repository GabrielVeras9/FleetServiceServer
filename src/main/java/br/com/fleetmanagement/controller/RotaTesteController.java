package br.com.fleetmanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.RotaTesteDTO;
import br.com.fleetmanagement.service.RotaTesteService;

@RestController
@RequestMapping("/api/rota")
public class RotaTesteController {
	
	@GetMapping
	public List<RotaTesteDTO> findAll(){
		List<RotaTesteDTO> result = rotaTesteService.findAll();
		return result;
	}

    @Autowired
    private RotaTesteService rotaTesteService;
    
    @GetMapping("/geojson")
    public ResponseEntity<String> obterRotaGeoJSON() {
        String rotaGeoJSON = rotaTesteService.obterRotaGeoJSON(); // Chama o serviço para obter o JSON da rota

        if (rotaGeoJSON != null) {
            return ResponseEntity.ok(rotaGeoJSON);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarRota(@RequestBody List<Map<String, Double>> routeData) {
        try {
            rotaTesteService.salvarRota(routeData);
            return new ResponseEntity<>("Rota salva com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar rota: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        	}
    	}
	}