package br.com.fleetmanagement.projection;

import java.sql.Date;

public interface ContratoProjection {

	Long getIdTab_Contrato();
	Integer getNum_Contrato();
	Date getIni_Vigencia();
	Date getFim_Vigencia();
	String getDoc_Contrato();
}
