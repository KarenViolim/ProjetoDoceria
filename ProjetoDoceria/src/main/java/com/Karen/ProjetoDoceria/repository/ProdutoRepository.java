package com.Karen.ProjetoDoceria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Karen.ProjetoDoceria.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
