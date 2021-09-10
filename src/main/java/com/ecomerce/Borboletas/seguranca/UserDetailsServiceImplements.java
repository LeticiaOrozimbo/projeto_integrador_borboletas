package com.ecomerce.Borboletas.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecomerce.Borboletas.modelos.Usuario;
import com.ecomerce.Borboletas.repositorios.UsuarioRepositorio;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio repositorio;

	/**
	 * Metodo utilizado para verificar existencia do usuario dentro do banco de
	 * dados e retornar um UserDetailsImplements com o usuario
	 * 
	 * @param String user, nome
	 * @author Borboletas
	 * @since 1.0
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repositorio.findByEmail(username);

		usuario.orElseThrow(() -> new UsernameNotFoundException(usuario + " not found."));

		return usuario.map(UserDetailsImplements::new).get();
	}
}
