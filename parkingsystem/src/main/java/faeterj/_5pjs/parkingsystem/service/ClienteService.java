package faeterj._5pjs.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faeterj._5pjs.parkingsystem.dto.ClienteDTO;
import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;

@Service
public class ClienteService {
    /* 
    @Autowired
    ClienteRepo repository;

    public void insertNewCliente(ClienteDTO dados){
        var cliente = repository.findByCpf(dados.cpf());

        if(cliente.isPresent()){
            System.out.println("Cliente já cadastrado.");
        }else{
            repository.save(new ClienteModel(dados.nome(), dados.cpf(), dados.telefone())); // INSERT
            System.out.println("Novo cliente cadastrado com sucesso.");
        }
    }*/
}
