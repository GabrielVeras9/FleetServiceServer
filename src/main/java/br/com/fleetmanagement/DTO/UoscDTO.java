package br.com.fleetmanagement.DTO;

import java.sql.Date;

import br.com.fleetmanagement.entity.Contrato;
import br.com.fleetmanagement.entity.Operador;
import br.com.fleetmanagement.entity.Servico;
import br.com.fleetmanagement.entity.Usuario;

public class UoscDTO {

	//(U)suario//
	private Long idusuario;
	private String nom_usuario;
	private String sen_usuario;
	private String email;
	private String cpf_usuario;
	private String rg_usuario;
	private String cep;
	private String cidade;
	private String bairro;
	
	//(O)peradora//
	private Long idtab_operador;
	private String nom_razao_social;
	private String cnpj_operador;
	
	//(S)ervico
	private Long idservico;
	private String desc_servico;
	private String nom_servico;
	
	//(C)ontrato
	private Long idtab_contrato;
	private Integer num_contrato;
	private Date ini_vigencia;
	private Date fim_vigencia;
	private String doc_contrato;
	
	public UoscDTO() {
	}

	public UoscDTO(Usuario Entity) {
		idusuario = Entity.getIdusuarioLong();
		nom_usuario = Entity.getNom_usuario();
		sen_usuario = Entity.getSen_usuario();
		email = Entity.getemail();
		cpf_usuario = Entity.getCpf_usuario();
		rg_usuario = Entity.getRg_usuario();
		cep = Entity.getCep();
		cidade = Entity.getCidade();
		bairro = Entity.getBairro();
	}

	public UoscDTO(Operador Entity) {
		idtab_operador = Entity.getidtab_operador();
		nom_razao_social = Entity.getNom_razao_social();
		cnpj_operador = Entity.getCnpj_operador();
	}

	public UoscDTO(Servico Entity) {
		idservico = Entity.getIdservico();
		desc_servico = Entity.getDesc_servico();
		nom_servico = Entity.getNom_servico();
	}

	public UoscDTO(Contrato Entity) {
		this.idtab_contrato = Entity.getIdtab_contrato();
		this.num_contrato = Entity.getNum_contrato();
		this.ini_vigencia = Entity.getIni_vigencia();
		this.fim_vigencia = Entity.getFim_vigencia();
		this.doc_contrato = Entity.getDoc_contrato();
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public String getSen_usuario() {
		return sen_usuario;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public String getRg_usuario() {
		return rg_usuario;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
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

	public Long getIdservico() {
		return idservico;
	}

	public String getDesc_servico() {
		return desc_servico;
	}

	public String getNom_servico() {
		return nom_servico;
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
