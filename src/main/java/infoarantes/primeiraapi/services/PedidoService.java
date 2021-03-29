package infoarantes.primeiraapi.services;


import infoarantes.primeiraapi.domain.Pedido;
import infoarantes.primeiraapi.repositories.PedidoRepository;
import infoarantes.primeiraapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! " +
                "Tipo:" + Pedido.class.getName()));

    }
}
