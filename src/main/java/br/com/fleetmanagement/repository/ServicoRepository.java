package br.com.fleetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fleetmanagement.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
