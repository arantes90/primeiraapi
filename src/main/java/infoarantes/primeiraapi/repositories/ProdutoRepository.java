package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
