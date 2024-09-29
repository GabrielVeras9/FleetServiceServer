package br.com.fleetmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_servico")//, schema = "fleet_homol" )
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idservico;
	private String desc_servico;
	private String nom_servico;
	
	public Servico() {
	}
	public Servico(Long idservico, String desc_servico, String nom_servico) {
		this.idservico = idservico;
		this.desc_servico = desc_servico;
		this.nom_servico = nom_servico;
	}
	public Long getIdservico() {
		return idservico;
	}
	public void setIdservico(Long idservico) {
		this.idservico = idservico;
	}
	public String getDesc_servico() {
		return desc_servico;
	}
	public void setDesc_servico(String desc_servico) {
		this.desc_servico = desc_servico;
	}
	public String getNom_servico() {
		return nom_servico;
	}
	public void setNom_servico(String nom_servico) {
		this.nom_servico = nom_servico;
	}
	
}
