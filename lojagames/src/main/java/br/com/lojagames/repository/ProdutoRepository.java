package br.com.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	public List<Produto> findAllByDescricaoContainingIgnoreCase( String nome);

}
