package br.com.fleetmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vwe_dados_linhas")//, schema = "fleet_homol")
public class Trajeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String extensao;
	private String tempoMedio;
	private String st_makeline;
	
	public Trajeto() {
		
	}

	public Trajeto(String extensao, String tempoMedio, String st_makeline) {
		super();
		this.extensao = extensao;
		this.tempoMedio = tempoMedio;
		this.st_makeline = st_makeline;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public String getSt_makeline() {
		return st_makeline;
	}

	public void setSt_makeline(String st_makeline) {
		this.st_makeline = st_makeline;
	}
}
