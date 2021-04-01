package infoarantes.primeiraapi.services;

import infoarantes.primeiraapi.domain.Cidade;
import infoarantes.primeiraapi.domain.Cliente;
import infoarantes.primeiraapi.domain.Endereco;
import infoarantes.primeiraapi.domain.enums.TipoCliente;
import infoarantes.primeiraapi.dto.ClienteDTO;
import infoarantes.primeiraapi.dto.ClienteNewDTO;
import infoarantes.primeiraapi.repositories.ClienteRepository;
import infoarantes.primeiraapi.repositories.EnderecoRepository;
import infoarantes.primeiraapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não teste! Id:"));

    }

    public Cliente insert(Cliente obj){
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());

        return obj;
    }

    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
        upadateData(newObj, obj);
        return repo.save(obj);
    }

    public void delete(Integer id){
        find(id);
        repo.deleteById(id);
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(),objDto.getNome(),
                objDto.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto){
        Cliente cli = new Cliente(objDto.getCidadeId(),objDto.getNome(),
                objDto.getEmail(), objDto.getCpfOuCnpj(),
                TipoCliente.toEnum(objDto.getTipo()));

        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);

        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(),
                objDto.getComplemnento(), objDto.getBairro(), objDto.getCep(), cli, cid);

        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if(objDto.getTelefone2() != null){
            cli.getTelefones().add(objDto.getTelefone2());
        }

        if(objDto.getTelefone3() != null){
            cli.getTelefones().add(objDto.getTelefone3());
        }

        return cli;
    }

    private void upadateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail()) ;
    }
}
