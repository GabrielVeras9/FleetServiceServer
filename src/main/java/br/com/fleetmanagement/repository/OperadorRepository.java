package br.com.fleetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Operador;
import br.com.fleetmanagement.projection.OperadorProjection;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT idtab_operador, nom_razao_social, cnpj_operador FROM fleet_homol.tab_operador where cnpj_operador = :cnpj_operador
			""")
	List<OperadorProjection> searchByCnpj(String cnpj_operador);
}
