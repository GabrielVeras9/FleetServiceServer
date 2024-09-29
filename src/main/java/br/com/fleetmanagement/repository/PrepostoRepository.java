package br.com.fleetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fleetmanagement.entity.Preposto;
import br.com.fleetmanagement.projection.PrepostoProjection;

public interface PrepostoRepository extends JpaRepository<Preposto, Long> {
	 @Query(nativeQuery = true, value = """
		      	select nome_motorista, email_motorista as emailMotorista, senha_motorista as senha_Motorista, cpf_motorista, rg_motorista, cnh_motorista, tipo_cnh, cep, cidade, bairro, doc_img FROM public.tab_preposto where LOWER(nome_motorista) LIKE LOWER(CONCAT('%', :nome_motorista, '%'))
		        """)
		    List<PrepostoProjection> searchByNom(String nome_motorista);

		    @Query(nativeQuery = true, value = """
		        SELECT public.tab_preposto.idpreposto, email_motorista, nome_motorista, cpf_motorista, rg_motorista, cnh_motorista, tipo_cnh, cep, cidade, bairro, doc_img FROM public.tab_preposto WHERE cpf_motorista = :cpf_motorista
		        """)
		    List<PrepostoProjection> searchByCpf(String cpf_motorista);
		    
		    Preposto findByEmailMotorista(String emailMotorista);
}
	