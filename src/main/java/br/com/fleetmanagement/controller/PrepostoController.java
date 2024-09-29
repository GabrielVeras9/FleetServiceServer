package br.com.fleetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.PrepostoDTO;
import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.exception.SenhaIncorretaException;
import br.com.fleetmanagement.exception.UsuarioNaoEncontradoException;
import br.com.fleetmanagement.service.PrepostoService;

@RestController
@RequestMapping(value = "/preposto/motorista")
public class PrepostoController {
	
	@Autowired
	private PrepostoService prepostoService;

	@GetMapping
	public List<PrepostoDTO> finAll(){
		List<PrepostoDTO> result = prepostoService.findAll();
		return result; 
	}
	@GetMapping(value = "/nome/{nome_motorista}")
    public List<PrepostoDTO> findByNom(@PathVariable String nome_motorista) {
        List<PrepostoDTO> result = prepostoService.findByNom(nome_motorista);
        return result;
    }

    @GetMapping(value = "/cpf/{cpf_motorista}")
    public List<PrepostoDTO> findByCPF(@PathVariable String cpf_motorista) {
        List<PrepostoDTO> result = prepostoService.findByCpf(cpf_motorista);
        return result;
    }
    
    @PostMapping(value ="/login")
    public ResponseEntity<?> login(@RequestBody PrepostoDTO prepostoDTO) {
        try {
        	Preposto preposto = prepostoService.autenticar(prepostoDTO.getEmailMotorista(), prepostoDTO.getSenha_motorista());
        
            return ResponseEntity.ok("Login realizado com sucesso para o usuário: " + preposto.getEmailMotorista());
        } catch (UsuarioNaoEncontradoException | SenhaIncorretaException e) {
           
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação: " + e.getMessage());
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }	

}
