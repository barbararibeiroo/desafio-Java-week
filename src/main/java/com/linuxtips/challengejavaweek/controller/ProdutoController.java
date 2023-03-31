package com.linuxtips.challengejavaweek.controller;


import com.linuxtips.challengejavaweek.model.Produto;
import com.linuxtips.challengejavaweek.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProduto() {
        return produtoService.listarProdutos();
    }

    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> buscarProdutoPeloId(@PathVariable(value = "id") Long id) {
        return produtoService.buscarProdutoPeloId(id);
    }

    @PutMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> atualizarProdutoPeloId(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProdutoPeloId(produto, id);
    }

    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> apagarPeloId(@PathVariable(value = "id") Long id) {
        return produtoService.apagarPeloId(id);
    }
    
}
