package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Pagamento;
import infoarantes.primeiraapi.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
