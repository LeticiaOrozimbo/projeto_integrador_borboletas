package com.borboletas.Borboletas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borboletas.Borboletas.model.Categoria;
import com.borboletas.Borboletas.repository.CategoriaRepositorio;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaControle {
	
	@Autowired
	private CategoriaRepositorio repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId (@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> buscarPorDescricao (@PathVariable String descricao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	
	@PostMapping("/criar")
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> atualizarCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
		
		Optional<Categoria> categoria = repository.findById(id);
		
		if (categoria.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Categoria não encontrada");
		}	
	}
	
}
