package com.projeto.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.inventario.dto.ProdutoDTO;
import com.projeto.inventario.entities.Produto;
import com.projeto.inventario.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public ProdutoDTO salvarProduto(ProdutoDTO dto) {
		Produto produto = new Produto();
		
		produto.setCodigo(dto.getCodigo());
		produto.setDescricao(dto.getDescricao());
		produto.setMedida(dto.getMedida());
		produto.setPreco(dto.getPreco());
		produto.setImgUrl(dto.getImgUrl());
		
		produto = produtoRepository.save(produto);

		return new ProdutoDTO(produto);
	}
	
	public List<ProdutoDTO> findAll(){
        List<Produto> lista = produtoRepository.findAll();
        return lista.stream().map(x-> new ProdutoDTO(x)).toList() ;
    }
	
	 public String deletarProduto(Long id) {
		 	produtoRepository.deleteById(id);
			return "Produto deletado!";
	}
	 
	 public Produto atualizarProduto(Long id, Produto atualizado) {
	    	Produto produto = produtoRepository.findById(id).get(); 
	    	
	    	produto.setCodigo(atualizado.getCodigo());
	    	produto.setDescricao(atualizado.getDescricao());
	    	produto.setMedida(atualizado.getMedida());
	    	produto.setPreco(atualizado.getPreco());
	    	produto.setImgUrl(atualizado.getImgUrl());
	    	
			return produtoRepository.save(produto);
		}
}
