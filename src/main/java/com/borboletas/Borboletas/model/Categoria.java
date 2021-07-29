package com.borboletas.Borboletas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String servicos_profissionais;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String beleza;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String moda;
	
	@NotNull
	@Size(min = 10, max = 100)
	private String acessorios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicos_profissionais() {
		return servicos_profissionais;
	}

	public void setServicos_profissionais(String servicos_profissionais) {
		this.servicos_profissionais = servicos_profissionais;
	}

	public String getBeleza() {
		return beleza;
	}

	public void setBeleza(String beleza) {
		this.beleza = beleza;
	}

	public String getModa() {
		return moda;
	}

	public void setModa(String moda) {
		this.moda = moda;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}
	
	

}
