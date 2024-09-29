package br.com.fleetmanagement.DTO;

import br.com.fleetmanagement.entity.Veiculo;
import br.com.fleetmanagement.projection.VeiculoProjection;

public class VeiculoDTO {

		private Long idtab_veiculo;
		private String modelo;
		private String marca;
		private String ano_fabricacao;
		private String renavam;
		private String cat_veiculo;
		private String num_placa;
		private String cepvei;
		private String cidadevei;
		private String bairrovei;
		private String doc_veiculo;
		private Boolean veiculo_ativo;
		private String cor_veiculo;
		
		public VeiculoDTO() {
		}
		
		public VeiculoDTO(Veiculo Entity) {
			idtab_veiculo = Entity.getIdtab_veiculo();
			modelo = Entity.getModelo();
			marca = Entity.getMarca();
			ano_fabricacao = Entity.getAno_fabricacao();
			renavam = Entity.getRenavam();
			cat_veiculo = Entity.getCat_veiculo();
			num_placa = Entity.getNum_placa();
			cepvei = Entity.getCepVei();
			cidadevei = Entity.getCidadeVei();
			bairrovei = Entity.getBairroVei();
			doc_veiculo = Entity.getDoc_veiculo();
			veiculo_ativo = Entity.getVeiculo_ativo();
			cor_veiculo = Entity.getCor_veiculo();
		}
		
		public VeiculoDTO(VeiculoProjection Projection) {
			num_placa = Projection.getNum_Placa();
			cor_veiculo = Projection.getCor_Veiculo();
			marca = Projection.getMarca();
			modelo = Projection.getModelo();
			ano_fabricacao = Projection.getAno_Fabricacao();
		}

		public Long getIdtab_veiculo() {
			return idtab_veiculo;
		}

		public void setIdtab_veiculo(Long idtab_veiculo) {
			this.idtab_veiculo = idtab_veiculo;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getAno_fabricacao() {
			return ano_fabricacao;
		}

		public void setAno_fabricacao(String ano_fabricacao) {
			this.ano_fabricacao = ano_fabricacao;
		}

		public String getRenavam() {
			return renavam;
		}

		public void setRenavam(String renavam) {
			this.renavam = renavam;
		}

		public String getCat_veiculo() {
			return cat_veiculo;
		}

		public void setCat_veiculo(String cat_veiculo) {
			this.cat_veiculo = cat_veiculo;
		}

		public String getNum_placa() {
			return num_placa;
		}

		public void setNum_placa(String num_placa) {
			this.num_placa = num_placa;
		}

		public String getCepvei() {
			return cepvei;
		}

		public void setCepvei(String cepvei) {
			this.cepvei = cepvei;
		}

		public String getCidadevei() {
			return cidadevei;
		}

		public void setCidadevei(String cidadevei) {
			this.cidadevei = cidadevei;
		}

		public String getBairrovei() {
			return bairrovei;
		}

		public void setBairrovei(String bairrovei) {
			this.bairrovei = bairrovei;
		}

		public String getDoc_veiculo() {
			return doc_veiculo;
		}

		public void setDoc_veiculo(String doc_veiculo) {
			this.doc_veiculo = doc_veiculo;
		}

		public Boolean isVeiculo_Ativo() {
	        return veiculo_ativo;
	    }

	    public void setVeiculo_Ativo(Boolean veiculo_ativo) {
	        this.veiculo_ativo = veiculo_ativo;
	    }

		public String getCor_veiculo() {
			return cor_veiculo;
		}

		public void setCor_veiculo(String cor_veiculo) {
			this.cor_veiculo = cor_veiculo;
		}
		
	}

