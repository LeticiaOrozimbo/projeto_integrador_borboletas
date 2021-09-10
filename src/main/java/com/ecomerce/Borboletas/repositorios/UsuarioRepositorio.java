package com.ecomerce.Borboletas.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.Borboletas.modelos.Usuario;

/**
 * Infertace utilizada para herdar
 * 
 * @author Borboletas
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	/**
	 * Metodo utilizado para selecionar apenas um usuário pelo e-mail(Chave Unica)
	 * 
	 * @param Email
	 * @return Optional com usuario unico
	 * @since 1.0
	 * @author Borboletas
	 */
	Optional<Usuario> findByEmail(String email);

	/**
	 * Metodo utilizado para perquisar coluna nome da tabela usuario
	 * 
	 * @param nome
	 * @return lista de usuario
	 * @since 1.0
	 * @author Borboletas
	 */
	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
