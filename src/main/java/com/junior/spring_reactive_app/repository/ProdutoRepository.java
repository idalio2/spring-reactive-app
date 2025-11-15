package com.junior.spring_reactive_app.repository;

import com.junior.spring_reactive_app.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
