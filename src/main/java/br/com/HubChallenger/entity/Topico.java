package br.com.HubChallenger.entity;

import java.time.LocalDateTime;

import br.com.HubChallenger.DTO.AtualizarTopicoRecord;
import br.com.HubChallenger.DTO.DadosCadastroTopico;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Table(name="topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String mensagem;

	private String autor;


	private LocalDateTime dataCriacao;

	@Enumerated(EnumType.STRING)
	private StatusTopico statusTopico;

	@Enumerated(EnumType.STRING)
	private Curso curso;
	
	
	public Topico( DadosCadastroTopico dados) {
	
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.autor = dados.autor();
		this.dataCriacao = dados.dataCriacao();
		this.statusTopico = StatusTopico.NAO_RESPONDIDO;
		this.curso = dados.curso();
		
	}
	
	
	public void atualizarTopico(AtualizarTopicoRecord atualizar) {
		
		this.statusTopico = atualizar.statusTopico();
		
	}

	
	public Topico() {
    }

	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public StatusTopico getStatusTopico() {
		return statusTopico;
	}


	public void setStatusTopico(StatusTopico statusTopico) {
		this.statusTopico = statusTopico;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
