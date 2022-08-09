package com.generation.lojaGames.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojaGames.Model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findByClassificacaoBetween(@Param("zero") int zero, @Param("classificacao") int classificacao);
	public List<ProdutoModel> findByPrecoBetween(@Param("de") BigDecimal de, @Param("ate") BigDecimal ate);
	
}
