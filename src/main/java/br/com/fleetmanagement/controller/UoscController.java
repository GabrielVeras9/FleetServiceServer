package br.com.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.UoscDTO;
import br.com.fleetmanagement.service.UoscService;

@RestController
@RequestMapping("/cadastro")
public class UoscController {
	
	@Autowired
    private UoscService uoscService;

    @PostMapping(value = "/criar/uosc")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UoscDTO dto) {
        uoscService.cadastrarUsuario(dto);
        return new ResponseEntity<>("Cadastro realizado com sucesso", HttpStatus.CREATED);
    }

}
