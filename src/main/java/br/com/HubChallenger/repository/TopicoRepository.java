package br.com.HubChallenger.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.HubChallenger.entity.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	Page<Topico> findAll(Pageable page);
	
	
}
