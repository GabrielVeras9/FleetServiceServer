package br.com.fleetmanagement.DTO;

import java.sql.Time;

import br.com.fleetmanagement.entity.Posicao;
import br.com.fleetmanagement.projection.PosicaoPrejection;

public class PosicaoDTO {
	
	private Long idtab_posicao;
	private String nomeMotorista;
	private String cpfMotorista;
	private String placaveiculo;
	private Time hr_prevista;
	private String latitude;
	private String longitude;
	
	public PosicaoDTO() {
	}

	public PosicaoDTO(Posicao entity) {
		idtab_posicao = entity.getIdtab_posicao();
		nomeMotorista = entity.getNomeMotorista();
		cpfMotorista = entity.getCpfMotorista();
		placaveiculo = entity.getPlacaveiculo();
		hr_prevista = entity.getHr_prevista();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
	}
	
	public PosicaoDTO(PosicaoPrejection Projection) {
		nomeMotorista = Projection.getNome_Motorista();
		cpfMotorista = Projection.getCpf_Motorista();
		placaveiculo = Projection.getPlacaVeiculo();
		hr_prevista = Projection.getHr_Prevista();
		latitude = Projection.getLatitude();
		longitude = Projection.getLongitude();
	}

	public Long getIdtab_posicao() {
		return idtab_posicao;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public String getCpfMotorista() {
		return cpfMotorista;
	}

	public String getPlacaveiculo() {
		return placaveiculo;
	}

	public Time getHr_prevista() {
		return hr_prevista;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
}
