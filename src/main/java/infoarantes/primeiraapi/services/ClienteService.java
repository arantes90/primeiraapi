package infoarantes.primeiraapi.services;

import infoarantes.primeiraapi.domain.Cliente;
import infoarantes.primeiraapi.repositories.ClienteRepository;
import infoarantes.primeiraapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id:"));

    }
}
