package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fleetmanagement.DTO.PrepostoDTO;
import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.exception.SenhaIncorretaException;
import br.com.fleetmanagement.exception.UsuarioNaoEncontradoException;
import br.com.fleetmanagement.projection.PrepostoProjection;
import br.com.fleetmanagement.repository.PrepostoRepository;

@Service
public class PrepostoService {

	@Autowired
	private PrepostoRepository prepostoRepository;
	
	public List<PrepostoDTO> findAll(){
		List<Preposto> result = prepostoRepository.findAll();
		return result.stream().map(x -> new PrepostoDTO(x)).toList();
	}
	
	public List<PrepostoDTO> findByNom(String nome_motorista){
		List<PrepostoProjection> result = prepostoRepository.searchByNom(nome_motorista);
		return result.stream().map(x -> new PrepostoDTO(x)).toList();
	}
	
	public List<PrepostoDTO> findByCpf(String cpf_motorista){
		List<PrepostoProjection> result = prepostoRepository.searchByCpf(cpf_motorista);
		return result.stream().map(x -> new PrepostoDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public Preposto autenticar(String emailMotorista, String senha_motorista) {
		Preposto preposto = prepostoRepository.findByEmailMotorista(emailMotorista);
        
        if (preposto == null) {
            throw new UsuarioNaoEncontradoException();
        }
        
        if (!preposto.getSenha_motorista().equals(senha_motorista)) {
            throw new SenhaIncorretaException();
        }
        return preposto;
    }
}
