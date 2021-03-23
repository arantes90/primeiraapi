package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Categoria;
import infoarantes.primeiraapi.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
