package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.PosicaoDTO;
import br.com.fleetmanagement.service.PosicaoService;

@RestController
@RequestMapping(value = "/posicao/veiculo")
public class PosicaoController {
	
	@Autowired
	private PosicaoService posicaoService;
	
	@GetMapping
	public List<PosicaoDTO> finAll(){
		List<PosicaoDTO> result = posicaoService.findAll();
		return result; 
	}
	
	@GetMapping(value = "/placa/{placaveiculo}")
    public List<PosicaoDTO> findByNome(@PathVariable String placaveiculo) {
        List<PosicaoDTO> result = posicaoService.findByPlaca(placaveiculo);
        return result;
    }
}