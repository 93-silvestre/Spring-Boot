package br.com.farmacia.controller;

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

import br.com.farmacia.model.ProdutoModel;
import br.com.farmacia.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ProdutoCategoria {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
    private ResponseEntity<List<ProdutoModel>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	
	}

	@GetMapping("/{id}")
	private ResponseEntity<ProdutoModel> getById(@PathVariable long id){
		
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> GetByTipo(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByDescricaoContainingIgnoreCase(nome));
			
    }
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postPostagem (@RequestBody ProdutoModel nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(nome));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel nome){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(nome));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtoRepository.deleteById(id);

}
}