package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Categoria;
import infoarantes.primeiraapi.domain.Cidade;
import infoarantes.primeiraapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
