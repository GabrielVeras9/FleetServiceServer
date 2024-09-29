package br.com.fleetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Posicao;
import br.com.fleetmanagement.projection.PosicaoPrejection;

public interface PosicaoRepository extends JpaRepository<Posicao, Long> {
	 @Query(nativeQuery = true, value = """
	select tab_posicao.codmotorista, tab_posicao.numveiculo, tab_posicao.placaveiculo, tab_posicao.hr_prevista, tab_posicao.latitude, tab_posicao.longitude FROM fleet_homol.tab_posicao where tab_posicao.placaveiculo = :placaveiculo
	""")
    List<PosicaoPrejection> searchByPlaca(String placaveiculo);
}