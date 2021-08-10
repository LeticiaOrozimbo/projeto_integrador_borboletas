package com.borboletas.Borboletas.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.borboletas.Borboletas.model.Usuario;
import com.borboletas.Borboletas.repositorio.UsuarioRepositorio;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	/**
	 * Metodo utilizado para verificar existencia do usuario dentro do banco de dados e 
	 * retornar um UserDetailsImplements com o usuario
	 * @param String user, nome
	 * @author Borboletas
	 * @since 1.0
	 */
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		Optional<Usuario>usuario = repositorio.findByEmail(username);
		
		if(usuario.isPresent()) {
			return new UserDetailsImplements(usuario.get());
		}else {
			throw new UsernameNotFoundException(username + "not found");
		}
	}
}
