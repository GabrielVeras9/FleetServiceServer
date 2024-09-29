package br.com.fleetmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_operador")//, schema = "fleet_homol" )
public class Operador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtab_operador;
	private String nom_razao_social;
	private String cnpj_operador;
	
	public Operador() {
	}

	public Operador(Long idtab_operador, String nom_razao_social, String cnpj_operador) {
		
		this.idtab_operador = idtab_operador;
		this.nom_razao_social = nom_razao_social;
		this.cnpj_operador = cnpj_operador;
	}

	public Long getidtab_operador() {
		return idtab_operador;
	}

	public void setIdtab_operadorLong(Long idtab_operadorLong) {
		this.idtab_operador = idtab_operadorLong;
	}

	public String getNom_razao_social() {
		return nom_razao_social;
	}

	public void setNom_razao_social(String nom_razao_social) {
		this.nom_razao_social = nom_razao_social;
	}

	public String getCnpj_operador() {
		return cnpj_operador;
	}

	public void setCnpj_operador(String cnpj_operador) {
		this.cnpj_operador = cnpj_operador;
	}

}
