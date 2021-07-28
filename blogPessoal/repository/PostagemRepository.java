package br.org.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogPessoal.model.Postagem;


// @Repository - indica que a Classe é uma Repository,
// ou seja, é responsável pela comunicação com o Banco de dados através dos métodos
// padrão e das Method Queries, que são consultas personalizadas através de palavras
// chave que representam as instruções da linguagem SQL
// Responsável pela comunicação com o banco de dados


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	//Esta method Query é equivalente a: select * from tb_postagem where titulo like "%titulo%";
	 
	
}
