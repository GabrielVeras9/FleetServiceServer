package br.com.fleetmanagement.DTO;

import java.sql.Timestamp;

import br.com.fleetmanagement.entity.VeiPorMotorista;

public class VeiPorMotoristaDTO {

	private Long idtab_veiPorMotorista;
	private String marca;
	private String modelo;
	private String placa_veiculo;
	private String cor_veiculo;
	private String fabricacao;
	private Timestamp inicio_rota;
	private Timestamp fim_rota;
	
	
	public VeiPorMotoristaDTO() {	
	}
	
	public VeiPorMotoristaDTO(VeiPorMotorista Entity) {
		
		idtab_veiPorMotorista = Entity.getIdtab_veiPorMotorista();
		marca = Entity.getMarca();
		modelo = Entity.getNum_placa();
		placa_veiculo = Entity.getNum_placa();
		cor_veiculo = Entity.getCor_veiculo();
		fabricacao = Entity.getFabricacao();
		inicio_rota = Entity.getInicio_rota();
		fim_rota = Entity.getFim_rota();
	}

	public Long getIdtab_veiPorMotorista() {
		return idtab_veiPorMotorista;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getNum_placa() {
		return placa_veiculo;
	}

	public String getCor_veiculo() {
		return cor_veiculo;
	}

	public String getFabricacao() {
		return fabricacao;
	}

	public Timestamp getInicio_rota() {
		return inicio_rota;
	}

	public Timestamp getFim_rota() {
		return fim_rota;
	}

}
