package br.com.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fleetmanagement.DTO.MotoAndVeiDTO;
import br.com.fleetmanagement.service.CadastroService;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

	@Autowired
    private CadastroService cadastroService;

	  @PostMapping("/veiculo-preposto")
	    public ResponseEntity<String> cadastrarVeiculoEPreposto(
	            @RequestPart("dto") MotoAndVeiDTO dto,
	            @RequestPart("file") MultipartFile file) {
	        cadastroService.cadastrarVeiculoEPreposto(dto, file);
	        return new ResponseEntity<>("Cadastro realizado com sucesso", HttpStatus.CREATED);
	    }
	}



