package infoarantes.primeiraapi.services;

import infoarantes.primeiraapi.domain.Categoria;
import infoarantes.primeiraapi.domain.Pedido;
import infoarantes.primeiraapi.repositories.CategoriaRepository;
import infoarantes.primeiraapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
        + "Tipo:" + Pedido.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }

}
