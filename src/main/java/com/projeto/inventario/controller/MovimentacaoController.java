package com.projeto.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.inventario.dto.MovimentacaoDTO;
import com.projeto.inventario.entities.Movimentacao;
import com.projeto.inventario.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping(value = "/registrar")
    public Movimentacao registrar(@RequestBody MovimentacaoDTO dto) {
        return movimentacaoService.registrarMovimentacao(dto);
    }

    @GetMapping(value = "/todos")
    public List<Movimentacao> listar() {
        return movimentacaoService.listarMovimentacoes();
    }
}
