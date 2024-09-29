package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.OperadorDTO;
import br.com.fleetmanagement.service.OperadorService;

@RestController
@RequestMapping(value = "/operador/operadoras")
public class OperadorController {
	
	@Autowired
	private OperadorService operadorService;
	
	@GetMapping
	public List<OperadorDTO> finAll(){
		List<OperadorDTO> result = operadorService.findAll();
		return result; 
	}
	
	@GetMapping(value = "/{cnpj_operador}")
	public List<OperadorDTO> findByList(@PathVariable String cnpj_operador) {
		List <OperadorDTO> result = operadorService.FindByCnpj(cnpj_operador);
		return result;
	}
}
