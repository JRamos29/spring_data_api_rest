package io.github.jramos29.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.jramos29.domain.entity.Cliente;
import io.github.jramos29.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    // Query method using convention
    List<Pedido> findByCliente(Cliente cliente);

    // Query method using @Query with jpql
    @Query(" select p from Pedido p left join fetch p.itens where p.id = :id ")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}