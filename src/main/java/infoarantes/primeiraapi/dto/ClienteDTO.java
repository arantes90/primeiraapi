package infoarantes.primeiraapi.dto;

import infoarantes.primeiraapi.domain.Cliente;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;

    public ClienteDTO(){}

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
