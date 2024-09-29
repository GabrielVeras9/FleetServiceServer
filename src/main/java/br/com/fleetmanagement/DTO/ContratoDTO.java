package br.com.fleetmanagement.DTO;

import java.sql.Date;

import br.com.fleetmanagement.entity.Contrato;
import br.com.fleetmanagement.projection.ContratoProjection;

public class ContratoDTO {

	private Long idtab_contrato;
	private Integer num_contrato;
	private Date ini_vigencia;
	private Date fim_vigencia;
	private String doc_contrato;
	
	public ContratoDTO() {
	}

	public ContratoDTO(Contrato Entity) {
		idtab_contrato = Entity.getIdtab_contrato();
		num_contrato = Entity.getNum_contrato();
		ini_vigencia = Entity.getIni_vigencia();
		fim_vigencia = Entity.getFim_vigencia();
		doc_contrato = Entity.getDoc_contrato();
	}
	
	public ContratoDTO(ContratoProjection Projection) {
		super();
		idtab_contrato = Projection.getIdTab_Contrato();
		num_contrato = Projection.getNum_Contrato();
		ini_vigencia = Projection.getIni_Vigencia();
		fim_vigencia = Projection.getFim_Vigencia();
		doc_contrato = Projection.getDoc_Contrato();
	}

	public Long getIdtab_contrato() {
		return idtab_contrato;
	}

	public Integer getNum_contrato() {
		return num_contrato;
	}

	public Date getIni_vigencia() {
		return ini_vigencia;
	}

	public Date getFim_vigencia() {
		return fim_vigencia;
	}

	public String getDoc_contrato() {
		return doc_contrato;
	}
	
}
