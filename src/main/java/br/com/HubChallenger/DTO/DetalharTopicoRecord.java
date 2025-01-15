package br.com.HubChallenger.DTO;

import java.time.LocalDateTime;

import br.com.HubChallenger.entity.Curso;
import br.com.HubChallenger.entity.StatusTopico;
import br.com.HubChallenger.entity.Topico;


public record DetalharTopicoRecord(Long id,String titulo,String mensagem,String autor,LocalDateTime dataCriacao,StatusTopico statusTopico,Curso curso) {

	public DetalharTopicoRecord(Topico topico) {
		this(
			topico.getId(),
			topico.getTitulo(),
			topico.getMensagem(),
			topico.getAutor(),
			topico.getDataCriacao(),
			topico.getStatusTopico(),
			topico.getCurso()
				);
		
		
	}
	
}
