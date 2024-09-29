package br.com.fleetmanagement.entity;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_posicao")//, schema = "fleet_homol")
public class Posicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtab_posicao;
	
	@Column(name = "nome_motorista")
	private String nomeMotorista;
	
	@Column(name = "cpf_motorista")
	private String cpfMotorista;
	private String placaveiculo;
	private Time hr_prevista;
	private String latitude;
	private String longitude;
	
	public Posicao() {
	}

	public Posicao(Long idtab_posicao, String nomeMotorista, String cpfMotorista, String placaveiculo, Time hr_prevista,
			String latitude,String longitude) {
		
		this.idtab_posicao = idtab_posicao;
		this.nomeMotorista = nomeMotorista;
		this.cpfMotorista = cpfMotorista;
		this.placaveiculo = placaveiculo;
		this.hr_prevista = hr_prevista;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getIdtab_posicao() {
		return idtab_posicao;
	}

	public void setIdtab_posicao(Long idtab_posicao) {
		this.idtab_posicao = idtab_posicao;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public String getCpfMotorista() {
		return cpfMotorista;
	}

	public void setCpfMotorista(String cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}

	public String getPlacaveiculo() {
		return placaveiculo;
	}

	public void setPlacaveiculo(String placaveiculo) {
		this.placaveiculo = placaveiculo;
	}

	public Time getHr_prevista() {
		return hr_prevista;
	}

	public void setHr_prevista(Time hr_prevista) {
		this.hr_prevista = hr_prevista;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String Longitude) {
		this.longitude = Longitude;
	}
}
