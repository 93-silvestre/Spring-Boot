package br.com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByDescricaoContainingIgnoreCase( String nome);
	
}
