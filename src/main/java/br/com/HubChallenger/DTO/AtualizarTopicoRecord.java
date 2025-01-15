package br.com.HubChallenger.DTO;

import br.com.HubChallenger.entity.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record AtualizarTopicoRecord(
		
		Long id,
		
		@NotNull
		StatusTopico statusTopico
		
		) {

}
