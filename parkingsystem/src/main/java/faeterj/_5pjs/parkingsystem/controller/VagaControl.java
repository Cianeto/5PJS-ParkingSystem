package faeterj._5pjs.parkingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@RestController
@Controller
@RequestMapping("/vagas")
public class VagaControl {
    
    @Autowired
    private VagaRepo vagaRepo;

    @GetMapping
    private List<VagaModel> listar (){
        return vagaRepo.findAll();
    }

    @PostMapping
    private void incluirVaga(@RequestBody VagaModel vagaModel){
        vagaRepo.save(vagaModel);
    }
}
