package br.com.fleetmanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_veiculo")//, schema = "fleet_homol")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtab_veiculo;
	private String modelo;
	private String marca;
	private String ano_fabricacao;
	private String renavam;
	private String cat_veiculo;
	private String num_placa;
	private String cepvei;
	private String cidadevei;
	private String bairrovei;
	private String doc_veiculo;
	private Boolean veiculo_ativo;
	private String cor_veiculo;

	public Veiculo() {
	}
	public Veiculo(Long idtab_veiculo, String modelo, String marca, String ano_fabricacao, String renavam,
			String cat_veiculo, String num_placa,String cepvei,String cidadevei,String bairrovei, String doc_veiculo, Boolean veiculo_ativo, String cor_veiculo) {
		
		this.idtab_veiculo = idtab_veiculo;
		this.modelo = modelo;
		this.marca = marca;
		this.ano_fabricacao = ano_fabricacao;
		this.renavam = renavam;
		this.cat_veiculo = cat_veiculo;
		this.num_placa = num_placa;
		this.cepvei = cepvei;
		this.cidadevei = cidadevei;
		this.bairrovei = bairrovei;
		this.doc_veiculo = doc_veiculo;
		this.veiculo_ativo = veiculo_ativo;
		this.cor_veiculo = cor_veiculo;
		
	}
	public Long getIdtab_veiculo() {
		return idtab_veiculo;
	}
	public void setIdtab_veiculo(Long idtab_veiculo) {
		this.idtab_veiculo = idtab_veiculo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(String ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getCat_veiculo() {
		return cat_veiculo;
	}
	public void setCat_veiculo(String cat_veiculo) {
		this.cat_veiculo = cat_veiculo;
	}
	public String getNum_placa() {
		return num_placa;
	}
	public void setNum_placa(String num_placa) {
		this.num_placa = num_placa;
	}
	public String getCepVei() {
		return cepvei;
	}
	public void setCepVei(String cepvei) {
		this.cepvei = cepvei;
	}
	public String getCidadeVei() {
		return cidadevei;
	}
	public void setCidadeVei(String cidadevei) {
		this.cidadevei = cidadevei;
	}
	public String getBairroVei() {
		return bairrovei;
	}
	public void setBairroVei(String bairrovei) {
		this.bairrovei = bairrovei;
	}
	public String getDoc_veiculo() {
		return doc_veiculo;
	}
	public void setDoc_veiculo(String doc_veiculo) {
		this.doc_veiculo = doc_veiculo;
	}
	public boolean getVeiculo_ativo() {
		return veiculo_ativo;
	}
	public void setVeiculo_ativo(Boolean veiculo_ativo) {
		this.veiculo_ativo = veiculo_ativo;
	}
	public String getCor_veiculo() {
		return cor_veiculo;
	}
	public void setCor_veiculo(String cor_veiculo) {
		this.cor_veiculo = cor_veiculo;
	}
	
}
