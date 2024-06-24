package faeterj._5pjs.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
public class ClienteControl {
    
    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping("/")
    public String showClientList(Model model) {
        model.addAttribute("clientes", clienteRepo.findAll());
        return "index"; // Name of the HTML file without the extension
    }
}
