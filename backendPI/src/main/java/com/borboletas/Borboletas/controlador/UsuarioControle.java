package com.borboletas.Borboletas.controlador;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.borboletas.Borboletas.model.Usuario;
import com.borboletas.Borboletas.model.UsuarioDTO;
import com.borboletas.Borboletas.repositorio.UsuarioRepositorio;
import com.borboletas.Borboletas.servicos.UsuarioServicos;

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
@RequestMapping("/api/v1/usuario")
@Api(tags = "Controlador de Usuario", description = "Utilitario de Usuarios")
@CrossOrigin("*")
public class UsuarioControle {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private UsuarioServicos servicos;

	@ApiOperation(value = "Salva novo usuario no sistema")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna usuario cadastrado"),
			@ApiResponse(code = 400, message = "Erro na requisição") })
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoCadastrado = servicos.cadastrarUsuario(novoUsuario);
		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@ApiOperation(value = "Autentica usuario no sistema")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna credenciais de usuario"),
			@ApiResponse(code = 400, message = "Erro na requisição ou usuario não credenciado") })
	@PutMapping("/autenticar")
	public ResponseEntity<Object> pegarCredenciais(@Valid @RequestBody UsuarioDTO loginsenha) {
		Optional<?> objetoCredenciado = servicos.pegarCredenciais(loginsenha);
		if (objetoCredenciado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCredenciado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@ApiOperation(value = "Busca lista de usuarios no sistema")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna lista de usuarios"),
			@ApiResponse(code = 204, message = "Retorno sem usuarios") })

	@GetMapping("/todes")
	public ResponseEntity<Object> buscarTodes() {
		List<Usuario> listaUsuarios = repositorio.findAll();

		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaUsuarios);
		}
	}

	@ApiOperation(value = "Busca usuario por Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna usuario existente"),
			@ApiResponse(code = 204, message = "Retorno inexistente") })
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long id) {
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}

	@ApiOperation(value = "Busca usuario por nome")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna usuario existente ou inexistente") })
	@GetMapping("/nome")
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}

	@ApiOperation(value = "Alterar usuario existente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retorna usuario alterado"),
			@ApiResponse(code = 400, message = "Id de usuario invalido") })
	@PutMapping("/alterar")
	public ResponseEntity<Object> alterar(@Valid @RequestBody UsuarioDTO novoUsuario) {
		Optional<?> objetoAlterado = servicos.alterarUsuario(novoUsuario);
		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@ApiOperation(value = "Deletar usuario existente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Caso deletado!"),
			@ApiResponse(code = 400, message = "Id de usuario invalido") })
	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<Usuario> objetoExistente = repositorio.findById(idUsuario);
		if (objetoExistente.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

}
