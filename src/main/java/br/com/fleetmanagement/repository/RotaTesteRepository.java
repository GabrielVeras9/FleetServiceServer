package br.com.fleetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.RotaTeste;

public interface RotaTesteRepository extends JpaRepository<RotaTeste, Long> {

    @Query(nativeQuery = true, value = "SELECT json_build_object(" +
            "'type', 'LineString'," +
            "'coordinates', json_agg(json_build_array(longitude, latitude))" +
            ") AS Rota_geojson FROM fleet_homol.tab_rota_test")
    String getRotaGeoJSON();
}
