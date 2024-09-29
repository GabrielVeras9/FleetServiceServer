package br.com.fleetmanagement.projection;

public interface PrepostoProjection {
	Long getIdPreposto(); 
	String getEmailMotorista();
	String getSenha_motorista();
    String getNome_Motorista(); 
    String getCpf_Motorista(); 
    String getRg_Motorista(); 
    String getCnh_Motorista(); 
    String getTipo_Cnh();  
    String getDoc_Img();
    String getCep();
    String getCidade();
    String getBairro();
}