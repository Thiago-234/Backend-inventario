package com.projeto.inventario.dto;

import com.projeto.inventario.entities.Produto;

public class ProdutoDTO {
	private Long id;
	private String codigo;
	private String descricao;
	private String nome;
	private float preco;
	private String medida;
	private String imgUrl;
	
	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String codigo, String descricao, String nome, float preco, String medida, String imgUrl) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.preco = preco;
		this.medida = medida;
		this.imgUrl = imgUrl;
	}
	
	public ProdutoDTO(Produto entity) {
		this.id = entity.getId();
		this.codigo = entity.getCodigo();
		this.descricao = entity.getDescricao();
		this.nome = entity.getNome();
		this.preco = entity.getPreco();
		this.medida = entity.getMedida();
		this.imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
