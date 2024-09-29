package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fleetmanagement.DTO.VeiculoDTO;
import br.com.fleetmanagement.service.CadastroVeiculoService;

@RestController
@RequestMapping("/veiculo/cadastrado")
public class CadastroVeiculoController {

	@Autowired
    private CadastroVeiculoService cadastroVeiculoService;
	
	@GetMapping
	public List<VeiculoDTO> findAll(){
		List<VeiculoDTO> result = cadastroVeiculoService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{num_placa}")
    public List<VeiculoDTO> findByNum(@PathVariable String num_placa) {
        List<VeiculoDTO> result = cadastroVeiculoService.findByNum(num_placa);
        return result;
    }

	  @PostMapping("/frota/veicular")
	    public ResponseEntity<String> cadastrarFrota(
	            @RequestPart("dto") VeiculoDTO dto,
	            @RequestPart("file") MultipartFile file) {
		  
		  cadastroVeiculoService.cadastrarFrota(dto, file);
	        return new ResponseEntity<>("Cadastro realizado com sucesso", HttpStatus.CREATED);
	    }
	}