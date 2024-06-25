package faeterj._5pjs.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;

@Controller
public class ClienteControl {
    
    @Autowired
    private ClienteRepo clienteRepo;

    // PAGINA INICIAL, MOSTRAR LISTA DE CLIENTES
    @GetMapping("/") 
    public String listarTodosClientes(Model model) {
        model.addAttribute("clientes", clienteRepo.findAll());
        return "ListaDeClientes";
    }

    // Method to handle the form submission
    @PostMapping("/insertCliente")
    public String inserirNovoCliente(@ModelAttribute ClienteModel cliente) {
        clienteRepo.save(cliente);

        return "redirect:/";
    }

    // DELETAR CLIENTE
    @PostMapping("/deleteCliente-1") 
    public String deletarCliente(@RequestParam Integer id){
        clienteRepo.deleteById(id);
        return "redirect:/";
    }

    @DeleteMapping("/deleteCliente/{id}")
    public String ddeletarCliente(@PathVariable int id){
        clienteRepo.deleteById(id);
        return "redirect:/";
    }

}
