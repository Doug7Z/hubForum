package br.com.HubChallenger.DTO;

import java.time.LocalDateTime;

import br.com.HubChallenger.entity.Curso;
import br.com.HubChallenger.entity.StatusTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
		
		@NotBlank
		String titulo,
		
		@NotBlank
		String mensagem,
		
		@NotBlank
		String autor,
		
		@NotNull
		LocalDateTime dataCriacao,
		
		@NotNull
		StatusTopico statusTopico,
		
		@NotNull
		Curso curso
		
		
		) {

}
