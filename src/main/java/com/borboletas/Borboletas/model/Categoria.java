package com.borboletas.Borboletas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Jaqueline,
 * @author Hebert
 * @author Letícia
 * @author Lucas
 * @author Yehokhanan
 * 
 * @category Classe que define a entidade categoria
 * @table Nome de nossa tabela principal
 *
 */
<<<<<<< HEAD
=======

/*Vai que vaiii! */

>>>>>>> 42e34f380ab4e3fddfd1d9d95c8c11e05b98d4aa
@Entity
@Table(name = "tb_categoria")
public class Categoria {

	//atualizaçao
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 500)
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
