package br.com.fleetmanagement.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_contrato")//, schema = "fleet_homol" )
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtab_contrato;
	private Integer num_contrato;
	private Date ini_vigencia;
	private Date fim_vigencia;
	private String doc_contrato;
	
	public Contrato() {
	}

	public Contrato(Long idtab_contrato, Integer num_contrato, Date ini_vigencia, Date fim_vigencia,
			String doc_contrato) {
		
		this.idtab_contrato = idtab_contrato;
		this.num_contrato = num_contrato;
		this.ini_vigencia = ini_vigencia;
		this.fim_vigencia = fim_vigencia;
		this.doc_contrato = doc_contrato;
	}

	public Long getIdtab_contrato() {
		return idtab_contrato;
	}

	public void setIdtab_contrato(Long idtab_contrato) {
		this.idtab_contrato = idtab_contrato;
	}

	public Integer getNum_contrato() {
		return num_contrato;
	}

	public void setNum_contrato(Integer num_contrato) {
		this.num_contrato = num_contrato;
	}

	public Date getIni_vigencia() {
		return ini_vigencia;
	}

	public void setIni_vigencia(Date ini_vigencia) {
		this.ini_vigencia = ini_vigencia;
	}

	public Date getFim_vigencia() {
		return fim_vigencia;
	}

	public void setFim_vigencia(Date fim_vigencia) {
		this.fim_vigencia = fim_vigencia;
	}

	public String getDoc_contrato() {
		return doc_contrato;
	}

	public void setDoc_contrato(String doc_contrato) {
		this.doc_contrato = doc_contrato;
	}
	
}
