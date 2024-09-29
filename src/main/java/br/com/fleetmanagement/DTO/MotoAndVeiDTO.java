package br.com.fleetmanagement.DTO;

import java.sql.Timestamp;

import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.entity.VeiPorMotorista;

public class MotoAndVeiDTO {

	// PrepostoDTO //
	private Long idpreposto;
	private String emailMotorista;
	private String senha_motorista;
	private String nome_motorista;
	private String cpf_motorista;
	private String rg_motorista;
	private String cnh_motorista;
	private String tipo_cnh;
	private String cep;
	private String cidade;
	private String bairro;
	private String doc_img;
	
	// VeiPorMotoristaDTO //
	private Long idtab_veiPorMotorista;
	private String marca;
	private String modelo;
	private String placa_veiculo;
	private String cor_veiculo;
	private String fabricacao;
	private Timestamp inicio_rota;
	private Timestamp fim_rota;
	
	public MotoAndVeiDTO() {
	}
	
	public MotoAndVeiDTO(Preposto Entity) {
		idpreposto = Entity.getIdpreposto();
		emailMotorista = Entity.getEmailMotorista();
		senha_motorista = Entity.getSenha_motorista();
		nome_motorista = Entity.getNome_motorista();
		cpf_motorista = Entity.getCpf_motorista();
		rg_motorista = Entity.getRg_motorista();
		cnh_motorista = Entity.getCnh_motorista();
		tipo_cnh = Entity.getTipo_cnh();
		cep = Entity.getCep();
		cidade = Entity.getCidade();
		bairro = Entity.getBairro();
		doc_img = Entity.getDoc_img();
	}
	
	public MotoAndVeiDTO(VeiPorMotorista Entity) {
		idtab_veiPorMotorista = Entity.getIdtab_veiPorMotorista();
		marca = Entity.getMarca();
		modelo = Entity.getModelo();
		placa_veiculo = Entity.getNum_placa();
		cor_veiculo = Entity.getCor_veiculo();
		fabricacao = Entity.getFabricacao();
		inicio_rota = Entity.getInicio_rota();
		fim_rota = Entity.getFim_rota();
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

	public String getDoc_img() {
		return doc_img;
	}

	public void setDoc_img(String doc_img) {
		this.doc_img = doc_img;
	}

	public Long getIdtab_veiPorMotorista() {
		return idtab_veiPorMotorista;
	}

	public void setIdtab_veiPorMotorista(Long idtab_veiPorMotorista) {
		this.idtab_veiPorMotorista = idtab_veiPorMotorista;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNum_placa() {
		return placa_veiculo;
	}

	public void setNum_placa(String num_placa) {
		this.placa_veiculo = num_placa;
	}

	public String getCor_veiculo() {
		return cor_veiculo;
	}

	public void setCor_veiculo(String cor_veiculo) {
		this.cor_veiculo = cor_veiculo;
	}

	public String getFabricacao() {
		return fabricacao;
	}

	public Timestamp getInicio_rota() {
		return inicio_rota;
	}

	public Timestamp getFim_rota() {
		return fim_rota;
	}

}
