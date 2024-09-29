package br.com.fleetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Veiculo;
import br.com.fleetmanagement.projection.VeiculoProjection;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	@Query(nativeQuery = true, value = """
	      	SELECT tv.num_placa, tv.cor_veiculo, tv.marca, tv.modelo, tv.ano_fabricacao FROM public.tab_veiculo tv where tv.num_placa = :num_placa
	        """)
	    List<VeiculoProjection> searchByNum(String num_placa);
}
