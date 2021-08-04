package com.borboletas.Borboletas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borboletas.Borboletas.model.Produto;
import com.borboletas.Borboletas.repository.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoControle {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> bucarPorId(@PathVariable (value = "id")Long id){
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> buscarPorNome (@PathVariable String nome){
		return ResponseEntity.ok(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Produto> criandoProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<Produto> AtualizarProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable Long id) {
		repositorio.deleteById(id);
	}
	
	
	
	
	
	
}
