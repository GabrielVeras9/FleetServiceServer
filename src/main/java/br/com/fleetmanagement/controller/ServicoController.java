package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.ServicoDTO;
import br.com.fleetmanagement.service.ServicoService;

@RestController
@RequestMapping(value = "/servico/prestado")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;
	
	@GetMapping
	public List<ServicoDTO> finAll(){
		List<ServicoDTO> result = servicoService.findAll();
		return result; 
	}
}
