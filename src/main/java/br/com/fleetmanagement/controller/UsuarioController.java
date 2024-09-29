package br.com.fleetmanagement.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fleetmanagement.DTO.AuthenticationDTO;
import br.com.fleetmanagement.DTO.LoginResponseDTO;
import br.com.fleetmanagement.DTO.RegistrarDTO;
import br.com.fleetmanagement.DTO.UsuarioMinDTO;
import br.com.fleetmanagement.entity.Usuario;
import br.com.fleetmanagement.repository.UsuarioRepository;
import br.com.fleetmanagement.service.TokenService;
import br.com.fleetmanagement.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario/cadastrado")
public class UsuarioController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	public List<UsuarioMinDTO> findAll(){
		List<UsuarioMinDTO> result = usuarioService.findAll();
		return result;
	}
	
	/*@GetMapping(value = "/{email}")
	public UsuarioMinDTO findById(@PathVariable String email) {
		UsuarioMinDTO result = usuarioService.findByEmail(email);
		return result;
	}*/
	
	@PostMapping(value ="/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
	    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.sen_usuario());
	    var auth = this.authenticationManager.authenticate(usernamePassword);
	    
	    var token = tokenService.generateToken((Usuario)auth.getPrincipal());
	    
	    return ResponseEntity.ok(new LoginResponseDTO(token, "/index"));
	}
	
	@PostMapping(value ="/registrar")
	public ResponseEntity<?> registrar(@RequestBody @Valid RegistrarDTO data){
	    if(this.usuarioRepository.findByEmail(data.email()) != null) {
	        return ResponseEntity.badRequest().build();
	    }
	    
	    String encryptedPassword = new BCryptPasswordEncoder().encode(data.sen_usuario());
	    Usuario newUsuario = new Usuario(
	        data.email(),
	        encryptedPassword,
	        data.Role()
	    );

	    newUsuario.setNom_usuario(data.nom_usuario());
	    newUsuario.setCpf_usuario(data.cpf_usuario());
	    newUsuario.setRg_usuario(data.rg_usuario());
	    newUsuario.setCep(data.cep());
	    newUsuario.setCidade(data.cidade());
	    newUsuario.setBairro(data.bairro());

	    this.usuarioRepository.save(newUsuario);
	    return ResponseEntity.ok().build();
	}
	/*@GetMapping("/validateToken")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token) {
        boolean isTokenValid = tokenService.validateToken(token);

        if (isTokenValid) {
            return ResponseEntity.ok("Token válido");
        } else {
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Token inválido");
        }
    }*/
}












