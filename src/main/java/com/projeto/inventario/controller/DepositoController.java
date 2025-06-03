package com.projeto.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.inventario.dto.DepositoDTO;
import com.projeto.inventario.entities.Deposito;
import com.projeto.inventario.service.DepositoService;

@RestController
@RequestMapping("/depositos")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    @PostMapping(value = "/criar")
    public DepositoDTO criar(@RequestBody DepositoDTO dto) {
        return depositoService.salvarDeposito(dto);
    }

    @GetMapping(value = "/todos")
    public List<Deposito> listar() {
        return depositoService.listarTodos();
    }
}
