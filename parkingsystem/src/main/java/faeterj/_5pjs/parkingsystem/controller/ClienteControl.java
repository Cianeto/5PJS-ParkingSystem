package faeterj._5pjs.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;

@RestController
@RequestMapping("/ClienteModel")
public class ClienteControl {
    
    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping
    public List<ClienteModel> listar (){
        return clienteRepo.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody ClienteModel clienteModel){
        clienteRepo.save(clienteModel);
    }

    @PutMapping
    public void alterar(@RequestBody ClienteModel clienteModel){
        clienteRepo.save(clienteModel);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        clienteRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> ler (@PathVariable int id){
        return clienteRepo.findById(id);
    } 
}
