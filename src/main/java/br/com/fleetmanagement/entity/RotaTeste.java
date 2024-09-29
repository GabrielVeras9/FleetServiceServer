package br.com.fleetmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_rota_test")//, schema = "fleet_homol")
public class RotaTeste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double latitude;
	private Double longitude;
	private Double extensao;
	private Double tempo_medio;
	
	public RotaTeste() {
	}

	public RotaTeste(Long id, Double latitude, Double longitude, Double extensao,Double tempo_medio) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.extensao = extensao;
		this.tempo_medio = tempo_medio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getExtensao() {
		return extensao;
	}

	public void setExtensao(Double extensao) {
		this.extensao = extensao;
	}

	public Double getTempo_medio() {
		return tempo_medio;
	}

	public void setTempo_medio(Double tempo_medio) {
		this.tempo_medio = tempo_medio;
	}
}
