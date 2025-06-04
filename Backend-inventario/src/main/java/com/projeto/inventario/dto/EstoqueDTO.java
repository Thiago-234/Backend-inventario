package com.projeto.inventario.dto;

import com.projeto.inventario.entities.Estoque;

public class EstoqueDTO {
	private Long produtoId;
    private Long depositoId;
    private int quantidade;

    public EstoqueDTO() {
	}

	public EstoqueDTO(Long produtoId, Long depositoId, int quantidade) {
		this.produtoId = produtoId;
		this.depositoId = depositoId;
		this.quantidade = quantidade;
	}

	public EstoqueDTO(Estoque entity) {
        this.produtoId = entity.getProduto().getId();
        this.depositoId = entity.getDeposito().getId();
        this.quantidade = entity.getQuantidade();
    }

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Long getDepositoId() {
		return depositoId;
	}

	public void setDepositoId(Long depositoId) {
		this.depositoId = depositoId;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
