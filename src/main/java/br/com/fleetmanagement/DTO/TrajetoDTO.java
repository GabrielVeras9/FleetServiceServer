package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Trajeto;

public class TrajetoDTO {
	
	private String extensao;
	private String tempoMedio;
	private String st_makeline;
	
	public TrajetoDTO() {
		
	}

	public TrajetoDTO(Trajeto Entity) {
		
		extensao = Entity.getExtensao();
		tempoMedio = Entity.getTempoMedio();
		st_makeline = Entity.getSt_makeline();
	}

	public String getExtensao() {
		return extensao;
	}

	public String getTempoMedio() {
		return tempoMedio;
	}

	public String getSt_makeline() {
		return st_makeline;
	}
}
