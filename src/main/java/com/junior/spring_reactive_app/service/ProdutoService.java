package com.junior.spring_reactive_app.service;

import com.junior.spring_reactive_app.model.Produto;
import com.junior.spring_reactive_app.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        List<Produto> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }
}
