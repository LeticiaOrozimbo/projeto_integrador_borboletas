package com.borboletas.Borboletas.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDTO {
	
	@NotNull
	private Long id;
	
	
	private String nome;
	
	@NotBlank(message = "Necessário e-mail")
	@Email(message = "Necessário email")
	private String email;
	
	@Size(min = 5, max = 100, message = "Necessário o minímo 5 de Caracteres")
	private String senha;
	
	private String token;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
