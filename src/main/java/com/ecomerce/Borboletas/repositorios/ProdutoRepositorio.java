package com.ecomerce.Borboletas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.Borboletas.modelos.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

}
