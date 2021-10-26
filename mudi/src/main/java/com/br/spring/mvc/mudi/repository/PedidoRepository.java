package com.br.spring.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.spring.mvc.mudi.model.Pedido;
import com.br.spring.mvc.mudi.model.StatusPedido;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByStatus(StatusPedido status);
	

	

}
