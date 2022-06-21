package io.github.jramos29.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jramos29.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {
}