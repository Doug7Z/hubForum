package br.com.HubChallenger.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.HubChallenger.repository.UsuarioRepository;



public class AuthService implements UserDetailsService{

	
	 @Autowired
	    private UsuarioRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        return repository.findByLogin(username);
	    }
}
