package com.generation.lojaGames.Controller;

import java.math.BigDecimal;
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

import com.generation.lojaGames.Model.ProdutoModel;
import com.generation.lojaGames.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/zero/{zero}/classificacao/{classificacao}")
	public ResponseEntity<List<ProdutoModel>> GetByClassificacao(@PathVariable int zero, @PathVariable int classificacao){
		return ResponseEntity.ok(produtoRepository.findByClassificacaoBetween(zero, classificacao));
	}
	
	@GetMapping("/de/{de}/ate/{ate}")
	public ResponseEntity<List<ProdutoModel>> GetByPreco(@PathVariable BigDecimal de, @PathVariable BigDecimal ate){
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(de,ate));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
}
