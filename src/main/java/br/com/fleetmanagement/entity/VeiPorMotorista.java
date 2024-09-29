package br.com.fleetmanagement.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "tab_veiculoPor_Motorista")//, schema = "fleet_homol")
	public class VeiPorMotorista {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idtab_veiPorMotorista;
		private String marca;
		private String modelo;
		private String fabricacao;
		private String placa_veiculo;
		private String cor_veiculo;
		private Timestamp inicio_rota;
		private Timestamp fim_rota;

		public VeiPorMotorista() {	
		}
		public VeiPorMotorista(Long idtab_veiPorMotorista, String marca, String modelo, String placa_veiculo, String cor_veiculo, String fabricacao,
				Timestamp inicio_rota, Timestamp fim_rota) {

			this.idtab_veiPorMotorista = idtab_veiPorMotorista;
			this.marca = marca;
			this.modelo = modelo;
			this.placa_veiculo = placa_veiculo;
			this.cor_veiculo = cor_veiculo;
			this.fabricacao = fabricacao;
			this.inicio_rota = inicio_rota;
			this.fim_rota = fim_rota;
			
		}
		public Long getIdtab_veiPorMotorista() {
			return idtab_veiPorMotorista;
		}
		public void setIdtab_veiPorMotorista(Long idtab_veiPorMotorista) {
			this.idtab_veiPorMotorista = idtab_veiPorMotorista;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getNum_placa() {
			return placa_veiculo;
		}
		public void setNum_placa(String placa_veiculo) {
			this.placa_veiculo = placa_veiculo;
		}
		public String getCor_veiculo() {
			return cor_veiculo;
		}
		public void setCor_veiculo(String cor_veiculo) {
			this.cor_veiculo = cor_veiculo;
		}
		public String getFabricacao() {
			return fabricacao;
		}
		public void setFabricacao(String fabricacao) {
			this.fabricacao = fabricacao;
		}
		public Timestamp getInicio_rota() {
			return inicio_rota;
		}
		public void setInicio_rota(Timestamp inicio_rota) {
			this.inicio_rota = inicio_rota;
		}
		public Timestamp getFim_rota() {
			return fim_rota;
		}
		public void setFim_rota(Timestamp fim_rota) {
			this.fim_rota = fim_rota;
		}
		
	}
