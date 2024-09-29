package br.com.fleetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Trajeto;


public interface TrajetoRepository extends JpaRepository<Trajeto, Long> {
	
	@Query(nativeQuery = true, value = """
	      	SELECT ST_AsGeoJSON(dl.st_makeline) AS geojson_line FROM public.vwe_dados_linhas dl;
	        """)
	String getGeoJSON();

}
