package io.github.jramos29.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.jramos29.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    // Query method using convention
    List<Cliente> findByNomeLike(String nome);

    // Query method with @Query using native SQL
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    // Query method with @Query using JPQL
    @Query(" delete from Cliente c where c.nome = :nome ")
    @Modifying
    void deleteByNome(String nome);

    // Query method using convention
    boolean existsByNome(String nome);

    // Query method with @Query using JPQL
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}