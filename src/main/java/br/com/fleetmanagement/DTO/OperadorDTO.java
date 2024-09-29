package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Operador;
import br.com.fleetmanagement.projection.OperadorProjection;

public class OperadorDTO {

	private Long idtab_operador;
	private String nom_razao_social;
	private String cnpj_operador;
	
	public OperadorDTO() {
	}

	public OperadorDTO(Operador Entity) {
		idtab_operador = Entity.getidtab_operador();
		nom_razao_social = Entity.getNom_razao_social();
		cnpj_operador = Entity.getCnpj_operador();
	}
	
	public OperadorDTO(OperadorProjection Projection) {
		idtab_operador = Projection.getIdTab_Operador();
		nom_razao_social = Projection.getNom_Razao_Social();
		cnpj_operador = Projection.getCnpj_Operador();
	}

	public Long getIdtab_operador() {
		return idtab_operador;
	}

	public String getNom_razao_social() {
		return nom_razao_social;
	}

	public String getCnpj_operador() {
		return cnpj_operador;
	}
}
