package br.org.generation.blogPessoal.controller;

// CAMADA CONTROLLER - É responsável pela comunicação com o Client (Postiman, Angular etc)
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogPessoal.model.Postagem;
import br.org.generation.blogPessoal.repository.PostagemRepository;



@RestController // se trata de um controlador (controle)
@RequestMapping("/postagens") //responderá as requisições
@CrossOrigin(origins = "*", allowedHeaders = "*") //permitirá o  recebimento de requisições realizadas de fora do domínio 
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll (){
		return ResponseEntity.ok(postagemRepository.findAll()); // OK = 200
	}
	@GetMapping("idifelse/{id}")
	public ResponseEntity<Postagem> getByIdIfElse(@PathVariable long id) {
		   Optional<Postagem> postagem = postagemRepository.findById(id);
			
	if (postagem.isPresent()) {
		return ResponseEntity.ok(postagem.get());
		}
	    return ResponseEntity.notFound().build();
}
}
