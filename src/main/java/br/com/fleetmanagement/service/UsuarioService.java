package br.com.fleetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fleetmanagement.DTO.UsuarioMinDTO;
import br.com.fleetmanagement.entity.Usuario;
import br.com.fleetmanagement.exception.SenhaIncorretaException;
import br.com.fleetmanagement.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEmail(username);
	}
	
	@Transactional(readOnly = true)
	public List<UsuarioMinDTO> findAll(){
		List<Usuario> result = usuarioRepository.findAll();
		return result.stream().map(x -> new UsuarioMinDTO(x)).toList();

	}
	
/*
	@Transactional(readOnly = true)
		public UsuarioMinDTO findByEmail(String email) {
		Usuario result = usuarioRepository.findByEmail(email);
		return new UsuarioMinDTO(result);
	}
	*/

	@Transactional(readOnly = true)
	public UserDetails autenticar(String email_usuario, String sen_usuario) {
	    UserDetails userDetails = usuarioRepository.findByEmail(email_usuario);

	    if (userDetails == null) {
	        throw new UsernameNotFoundException("Usuário não encontrado");
	    }

	    if (!userDetails.getPassword().equals(sen_usuario)) {
	        throw new SenhaIncorretaException();
	    }
	    
	    return userDetails;
	}
}
