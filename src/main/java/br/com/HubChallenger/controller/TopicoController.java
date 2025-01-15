package br.com.HubChallenger.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.HubChallenger.DTO.AtualizarTopicoRecord;
import br.com.HubChallenger.DTO.DadosCadastroTopico;
import br.com.HubChallenger.DTO.DetalharTopicoRecord;
import br.com.HubChallenger.DTO.ListarTopicosRecord;
import br.com.HubChallenger.entity.Topico;
import br.com.HubChallenger.repository.TopicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	
	@GetMapping
	public ResponseEntity<Page<ListarTopicosRecord>> listarOsTopicos(
	        @PageableDefault(size = 10, sort = { "titulo" }) Pageable paginacao) {
	    Page<Topico> page = topicoRepository.findAll(paginacao); 
	    Page<ListarTopicosRecord> records = page.map(ListarTopicosRecord::new);
	    return ResponseEntity.ok(records); 
	}
	
	

	@PostMapping
	@Transactional
	public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados,
			UriComponentsBuilder uribuilder) {

		Topico topico = new Topico(dados);
		topicoRepository.save(topico);
		URI uri = uribuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalharTopicoRecord(topico));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirTopico(@PathVariable Long id) {
		topicoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity atualizarTopico(@RequestBody @Valid AtualizarTopicoRecord statusTopico,@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.atualizarTopico(statusTopico);
		return ResponseEntity.ok(new DetalharTopicoRecord(topico));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity detalharTopico (@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		return ResponseEntity.ok(new DetalharTopicoRecord(topico));
	}

}
