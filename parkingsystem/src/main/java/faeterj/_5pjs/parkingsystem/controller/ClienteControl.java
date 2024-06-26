package faeterj._5pjs.parkingsystem.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;

@Controller
public class ClienteControl {
    
    @Autowired
    private ClienteRepo clienteRepo;

    // PAGINA INICIAL, MOSTRAR LISTA DE CLIENTES
    @GetMapping("/") 
    public String listarTodosClientes(Model model){
        model.addAttribute("clientes", clienteRepo.findAll());
        return "index";
    }

    // INSERIR CLIENTE
    @PostMapping("/insertCliente")
    public ResponseEntity<?> inserirNovoCliente(@ModelAttribute ClienteModel cliente){
        Optional<ClienteModel> existingCliente = clienteRepo.findByCpf(cliente.getCpf());
        if (existingCliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente com CPF " + cliente.getCpf() + " já existe.");
        } else {
            clienteRepo.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }
    }

    /* @PutMapping("/updateCliente/{id}")
    public ResponseEntity<?> atualizarCliente(){
        

    } */

    // DELETAR CLIENTE
    @DeleteMapping("/deleteCliente/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id){
        if (clienteRepo.existsById(id)) {
            clienteRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente_id: " + id + "not found.");
        }
    }
}
