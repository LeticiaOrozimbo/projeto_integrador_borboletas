package com.ecomerce.Borboletas.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.Borboletas.modelos.Categoria;
import com.ecomerce.Borboletas.modelos.Produto;
import com.ecomerce.Borboletas.repositorios.CategoriaRepositorio;
import com.ecomerce.Borboletas.repositorios.ProdutoRepositorio;
import com.ecomerce.Borboletas.repositorios.UsuarioRepositorio;

@Service
public class ProdutoServicos {

	private @Autowired ProdutoRepositorio repositorioP;
	private @Autowired UsuarioRepositorio repositorioU;
	private @Autowired CategoriaRepositorio repositorioC;

	/**
	 * Método utilizado para cadastrar um produto novo no banco validando se o
	 * usuario criador é existente. Id do usuario criador e o id do categoria deve
	 * ser passado dentro do objeto produto para que a criação seja efetuada. Caso
	 * id do usuario ou tema não for passado retona um Optiona.empty()
	 * 
	 * @param novoProduto do tipo Produto
	 * @return Optional com Produto
	 */
	public Optional<?> cadastrarProduto(Produto novoProduto) {
		Optional<Categoria> objetoExistente = repositorioC.findById(novoProduto.getCategoria().getId());
		return repositorioU.findById(novoProduto.getCriador().getId()).map(usuarioExistente -> {
			if (objetoExistente.isPresent()) {
				novoProduto.setCriador(usuarioExistente);
				novoProduto.setCategoria(objetoExistente.get());
				return Optional.ofNullable(repositorioP.save(novoProduto));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}
