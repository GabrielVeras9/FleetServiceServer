package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Servico;

public class ServicoDTO {
	
	private Long idservico;
	private String desc_servico;
	private String nom_servico;

	public ServicoDTO() {
	}

	public ServicoDTO(Servico Entity) {

		idservico = Entity.getIdservico();
		desc_servico = Entity.getDesc_servico();
		nom_servico = Entity.getNom_servico();
	}

	public Long getIdservico() {
		return idservico;
	}

	public String getDesc_servico() {
		return desc_servico;
	}

	public String getNom_servico() {
		return nom_servico;
	}
	
}
