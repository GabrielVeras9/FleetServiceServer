package br.com.fleetmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_preposto")//, schema = "fleet_homol")
public class Preposto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpreposto;
	
	@Column(name = "email_motorista")
	private String  emailMotorista;
	private String senha_motorista;
	private String nome_motorista;
	private String cpf_motorista;
	private String rg_motorista;
	private String cnh_motorista;
	private String tipo_cnh;
	private String doc_img;
	private String cep;
	private String cidade;
	private String bairro;
	
	public Preposto() {
	}

	public Preposto(Long idpreposto, String emailMotorista, String senha_motorista,String nome_motorista, String cpf_motorista, String rg_motorista,
			String cnh_motorista, String tipo_cnh, String doc_img,String cep,String cidade,String bairro) {
		this.idpreposto = idpreposto;
		this.emailMotorista = emailMotorista;
		this.senha_motorista = senha_motorista;
		this.nome_motorista = nome_motorista;
		this.cpf_motorista = cpf_motorista;
		this.rg_motorista = rg_motorista;
		this.cnh_motorista = cnh_motorista;
		this.tipo_cnh = tipo_cnh;
		this.doc_img = doc_img;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public Long getIdpreposto() {
		return idpreposto;
	}

	public void setIdpreposto(Long idpreposto) {
		this.idpreposto = idpreposto;
	}

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
