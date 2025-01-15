package br.com.HubChallenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.HubChallenger.DTO.Autenticacao;
import br.com.HubChallenger.DTO.TokenJWT;
import br.com.HubChallenger.security.ServiceToken;
import br.com.HubChallenger.security.Usuario;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	 @Autowired
	 private AuthenticationManager manager;
	 
	 @Autowired
	 private ServiceToken serviceToken;
	 
	 
	 public ResponseEntity efetuarLogin(@RequestBody @Valid Autenticacao dados) {
		 var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
	        var authentication = manager.authenticate(authenticationToken);

	        var tokenJWT = serviceToken.gerarToken((Usuario) authentication.getPrincipal());

	        return ResponseEntity.ok(new TokenJWT(tokenJWT));
	 }

}
