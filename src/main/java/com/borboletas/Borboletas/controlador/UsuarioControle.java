package com.borboletas.Borboletas.controlador;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControle {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private UsuarioServicos servicos;
	
	@PostMapping("/cadastrar")//Esta funcionando
	public ResponseEntity<Object>cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario){
		Optional<Object>objetoCadastrado = servicos.cadastrarUsuario(novoUsuario);
		if(objetoCadastrado.isPresent()){
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		}else {
			return ResponseEntity.status(400).build();
		}
	}
	@PutMapping("/logar")//Esta funcionando
	public ResponseEntity<Object>pegarCredenciais(@Valid @RequestBody UsuarioDTO loginsenha){
		Optional<?>objetoCredenciado = servicos.pegarCredenciais(loginsenha);
		if(objetoCredenciado.isPresent()){
			return ResponseEntity.status(201).body(objetoCredenciado.get());
		}else {
			return ResponseEntity.status(400).build();
	}
  }
	@GetMapping("/{id_usuario}")//Esta funcionando
	public ResponseEntity<Usuario>buscarPorId(@PathVariable (value = "id_usuario")Long id){
		return ResponseEntity.status(200).body(repositorio.findById(id).get());
	}
	@GetMapping("/nome")//Esta funcionando
	public ResponseEntity<List<Usuario>>buscarPorNome(@RequestParam(defaultValue = "")String nome){
		return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	@PutMapping("/alterar")//Esta funcionando
	public ResponseEntity<Object>alterar(@Valid @RequestBody UsuarioDTO novoUsuario){
		Optional<?>objetoAlterado = servicos.alterarUsuario(novoUsuario);
		if(objetoAlterado.isPresent()){
			return ResponseEntity.status(201).body(objetoAlterado.get());
		}else {
			return ResponseEntity.status(400).build();
		}
    }
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable Long id) {
		repositorio.deleteById(id);
   }
}
