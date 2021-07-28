package br.org.generation.blogPessoal.controller;

// CAMADA CONTROLLER - É responsável pela comunicação com o Client (Postiman, Angular etc)
import java.util.List;

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

import br.org.generation.blogPessoal.model.Postagem;
import br.org.generation.blogPessoal.repository.PostagemRepository;



@RestController // se trata de um controlador (controle)
@RequestMapping("/postagens") //responderá as requisições
@CrossOrigin(origins = "*", allowedHeaders = "*") //permitirá o  recebimento de requisições realizadas de fora do domínio 
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll (){
		return ResponseEntity.ok(repository.findAll()); // OK = 200
	}
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		 return repository.findById(id)
	      .map(resp -> ResponseEntity.ok(resp))
	      .orElse(ResponseEntity.notFound().build());
     }
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping
	public ResponseEntity<Postagem>post (@RequestBody Postagem postagem){
	 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
}
	@PutMapping
	public ResponseEntity<Postagem>put(@RequestBody Postagem postagem){
	 return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}

		   
		       
	

