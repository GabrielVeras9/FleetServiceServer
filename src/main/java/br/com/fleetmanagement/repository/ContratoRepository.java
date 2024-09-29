package br.com.fleetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Contrato;
import br.com.fleetmanagement.projection.ContratoProjection;

public interface ContratoRepository extends JpaRepository<Contrato, Long>  {

	@Query(nativeQuery = true, value = """
		SELECT tab_contrato.idtab_contrato, tab_contrato.num_contrato, tab_contrato.ini_vigencia, tab_contrato.fim_vigencia, tab_contrato.doc_contrato FROM fleet_homol.tab_contrato INNER JOIN fleet_homol.tab_contrato_preposto on tab_contrato.idtab_contrato = tab_contrato_preposto.idcontrato_preposto INNER JOIN fleet_homol.tab_contrato_veiculo ON tab_contrato.idtab_contrato = tab_contrato_veiculo.idtab_veiculo WHERE tab_contrato.num_contrato = :num_Contrato
		""")
	List<ContratoProjection> searchByNumContrato(String num_Contrato);
}

