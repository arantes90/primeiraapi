package infoarantes.primeiraapi.repositories;

import infoarantes.primeiraapi.domain.Categoria;
import infoarantes.primeiraapi.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
