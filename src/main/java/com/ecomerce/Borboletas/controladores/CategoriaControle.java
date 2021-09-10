package com.ecomerce.Borboletas.controladores;

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

import com.ecomerce.Borboletas.modelos.Categoria;
import com.ecomerce.Borboletas.repositorios.CategoriaRepositorio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
@Api(tags = "Controlador de Categoria", description = "Utilitario de Categoria")
@CrossOrigin("*")
public class CategoriaControle {

	@Autowired
	private CategoriaRepositorio repository;

	@ApiOperation(value = "Busca lista de categoria no sistema")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna lista de categoria"),
			@ApiResponse(code = 204, message = "Retorno sem produto") })
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		return ResponseEntity.ok(repository.findAll());
	}

	@ApiOperation(value = "Busca categoria por Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna categoria existente"),
			@ApiResponse(code = 204, message = "Retorno inexistente") })
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}

	@ApiOperation(value = "Busca categoria por descricao")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna categoria existente ou inexistente") })
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> buscarPorDescricao(@PathVariable String descricao) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@ApiOperation(value = "Salva nova categoria no sistema")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna categoria cadastrado"),
			@ApiResponse(code = 400, message = "Erro na requisição") })
	@PostMapping("/criar")
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@ApiOperation(value = "Atualiza categoria existente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna categoria alterado"),
			@ApiResponse(code = 400, message = "Id de categoria invalido") })
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> atualizarCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	

}
