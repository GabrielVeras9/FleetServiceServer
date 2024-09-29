package br.com.fleetmanagement.projection;

import java.sql.Time;

public interface PosicaoPrejection {
	String getNome_Motorista();
	String getCpf_Motorista();
    String getPlacaVeiculo();
    Time getHr_Prevista();
    String getGeoJson();
    String getLatitude();
	String getLongitude();
}
