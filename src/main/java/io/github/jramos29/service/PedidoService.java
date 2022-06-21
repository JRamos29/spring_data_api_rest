package io.github.jramos29.service;

import java.util.Optional;

import io.github.jramos29.domain.entity.Pedido;
import io.github.jramos29.domain.enums.StatusPedido;
import io.github.jramos29.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}