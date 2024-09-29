package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Usuario;
import br.com.fleetmanagement.enuns.UsuarioEnuns;

public class UsuarioMinDTO {
	
	private Long idusuario;
	private String nom_usuario;
	private String sen_usuario;
	private String email;
	private String cpf_usuario;
	private String rg_usuario;
	private String cep;
	private String cidade;
	private String bairro;
	private UsuarioEnuns Role;
	
	public UsuarioMinDTO() {
	}

	public UsuarioMinDTO(Usuario entity) {
		idusuario = entity.getIdusuarioLong();
		nom_usuario = entity.getNom_usuario();
		sen_usuario = entity.getSen_usuario();
		email = entity.getemail();
		cpf_usuario = entity.getCpf_usuario();
		rg_usuario = entity.getRg_usuario();
		cep = entity.getCep();
		cidade = entity.getCidade();
		bairro = entity.getBairro();
		Role = entity.getRole();
		
	}

	public Long getIdUsuario() {
		return idusuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}
	
	public String getSen_usuario() {
		return sen_usuario;
	}


	public String getEmail() {
		return email;
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}
	
	public String getRg_usuario() {
		return rg_usuario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public UsuarioEnuns getRole() {
		return Role;
	}

	public void setRole(UsuarioEnuns role) {
		Role = role;
	}
	
	
}

