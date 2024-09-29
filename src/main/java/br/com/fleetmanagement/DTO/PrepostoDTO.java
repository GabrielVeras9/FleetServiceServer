package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.projection.PrepostoProjection;

public class PrepostoDTO {
	
	//private Long idpreposto;
	private String nome_motorista;
	private String emailMotorista;
	private String senha_motorista;
	private String cpf_motorista;
	private String rg_motorista;
	private String cnh_motorista;
	private String tipo_cnh;
	private String cep;
	private String cidade;
	private String bairro;
	private String doc_img;
	
	public PrepostoDTO() {
	}

	public PrepostoDTO(Preposto Entity) {
		//idpreposto = Entity.getIdpreposto();
		emailMotorista = Entity.getEmailMotorista();
		senha_motorista = Entity.getSenha_motorista();
		nome_motorista = Entity.getNome_motorista();
		cpf_motorista = Entity.getCpf_motorista();
		rg_motorista = Entity.getRg_motorista();
		cnh_motorista = Entity.getCnh_motorista();
		tipo_cnh = Entity.getTipo_cnh();		
		doc_img = Entity.getDoc_img();
		cep = Entity.getCep();
		cidade = Entity.getCidade();
		bairro = Entity.getCidade();
	}
	
	public PrepostoDTO(PrepostoProjection Projection) {
		//idpreposto = Projection.getIdPreposto();
		emailMotorista = Projection.getEmailMotorista();
		nome_motorista = Projection.getNome_Motorista();
		cpf_motorista = Projection.getCpf_Motorista();
		rg_motorista = Projection.getRg_Motorista();
		cnh_motorista = Projection.getCnh_Motorista();
		tipo_cnh = Projection.getTipo_Cnh();
		cep = Projection.getCep();
		cidade = Projection.getCidade();
		bairro = Projection.getBairro();
		doc_img = Projection.getDoc_Img();
	}

	/*public Long getIdpreposto() {
		return idpreposto;
	}*/

	/*public void setIdpreposto(Long idpreposto) {
		this.idpreposto = idpreposto;
	}*/

	public String getEmailMotorista() {
		return emailMotorista;
	}

	public void setEmailMotorista(String emailMotorista) {
		this.emailMotorista = emailMotorista;
	}

	public String getSenha_motorista() {
		return senha_motorista;
	}

	public void setSenha_motorista(String senha_motorista) {
		this.senha_motorista = senha_motorista;
	}

	public String getNome_motorista() {
		return nome_motorista;
	}

	public void setNome_motorista(String nome_motorista) {
		this.nome_motorista = nome_motorista;
	}

	public String getCpf_motorista() {
		return cpf_motorista;
	}

	public void setCpf_motorista(String cpf_motorista) {
		this.cpf_motorista = cpf_motorista;
	}

	public String getRg_motorista() {
		return rg_motorista;
	}

	public void setRg_motorista(String rg_motorista) {
		this.rg_motorista = rg_motorista;
	}

	public String getCnh_motorista() {
		return cnh_motorista;
	}

	public void setCnh_motorista(String cnh_motorista) {
		this.cnh_motorista = cnh_motorista;
	}

	public String getTipo_cnh() {
		return tipo_cnh;
	}

	public void setTipo_cnh(String tipo_cnh) {
		this.tipo_cnh = tipo_cnh;
	}

	public String getDoc_img() {
		return doc_img;
	}

	public void setDoc_img(String doc_img) {
		this.doc_img = doc_img;
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
}
