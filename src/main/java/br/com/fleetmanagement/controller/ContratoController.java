package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.ContratoDTO;
import br.com.fleetmanagement.service.ContratoService;

@RestController
@RequestMapping(value = "/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoService contratoService;
	
	@GetMapping
	public List<ContratoDTO> finAll(){
		List<ContratoDTO> result = contratoService.findAll();
		return result; 
	}
	
	@GetMapping(value = "/{num_Contrato}")
	public List<ContratoDTO> findByList(@PathVariable String num_Contrato){
		List<ContratoDTO> result = contratoService.findByNumContrato(num_Contrato);
		return result;
	}
}
