package com.borboletas.Borboletas.controlador;

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

import com.borboletas.Borboletas.model.Produto;
import com.borboletas.Borboletas.repositorio.ProdutoRepositorio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controlador responsavel por retornar status na nossa API no Swagger
 * 
 * @author Borboletas
 * @since 1.0
 * 
 */
@RestController
@RequestMapping("/produto")
@Api(tags = "Controlador de Produto", description = "Utilitario de Produtos")
@CrossOrigin("*")
public class ProdutoControle {

	@Autowired
	private ProdutoRepositorio repositorio;

	@ApiOperation(value = "Busca lista de produtos no sistema")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna lista de produtos"),
			@ApiResponse(code = 204, message = "Retorno sem produto") })
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@ApiOperation(value = "Busca produto por Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna produto existente"),
			@ApiResponse(code = 204, message = "Retorno inexistente") })
	@GetMapping("/{id}")
	public ResponseEntity<Produto> bucarPorId(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}

	@ApiOperation(value = "Busca usuario por nome")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna produto existente ou inexistente") })
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}

	@ApiOperation(value = "Salva novo produto no sistema")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna produto cadastrado"),
			@ApiResponse(code = 400, message = "Erro na requisição") })
	@PostMapping("/criar")
	public ResponseEntity<Produto> criandoProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}

	@ApiOperation(value = "Atualiza produto existente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna produto alterado"),
			@ApiResponse(code = 400, message = "Id de produto invalido") })
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> AtualizarProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}

	@ApiOperation(value = "Deletar produto existente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Caso deletado!"),
			@ApiResponse(code = 400, message = "Id de produto invalido") })
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Long id) {
		Optional<Produto> objetoExistente = repositorio.findById(id);

		if (objetoExistente.isPresent()) {
			repositorio.deleteById(id);
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

}
