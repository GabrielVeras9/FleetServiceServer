package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.RotaTeste;

public class RotaTesteDTO {
	
	private Long id;
	private Double latitude;
	private Double longitude;
	private Double extensao;
	private Double tempo_medio;
	
	public RotaTesteDTO() {
	}

	public RotaTesteDTO(RotaTeste Entity) {
		id = Entity.getId();
		latitude = Entity.getLatitude();
		longitude = Entity.getLongitude();
		extensao = Entity.getExtensao();
		tempo_medio = Entity.getTempo_medio();
	}

	public Long getId() {
		return id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getExtensao() {
		return extensao;
	}

	public Double getTempo_medio() {
		return tempo_medio;
	}
}
