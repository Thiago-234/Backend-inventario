package com.projeto.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.inventario.dto.EstoqueDTO;
import com.projeto.inventario.entities.Deposito;
import com.projeto.inventario.entities.Estoque;
import com.projeto.inventario.entities.Produto;
import com.projeto.inventario.repositories.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque salvar(EstoqueDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getProdutoId());

        Deposito deposito = new Deposito();
        deposito.setId(dto.getDepositoId());

        Estoque estoque = new Estoque(produto, deposito, dto.getQuantidade());
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Estoque atualizarQuantidade(Long id, int novaQuantidade) {
        Estoque estoque = estoqueRepository.findById(id).get();
        estoque.setQuantidade(novaQuantidade);
        return estoqueRepository.save(estoque);
    }

    public void deletar(Long id) {
        estoqueRepository.deleteById(id);
    }
}

