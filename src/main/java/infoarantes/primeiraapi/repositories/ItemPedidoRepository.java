package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Categoria;
import infoarantes.primeiraapi.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
