package faeterj._5pjs.parkingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import faeterj._5pjs.parkingsystem.dto.VeiculoDTO;
import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.model.VeiculoModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;

@RestController
@Controller
@RequestMapping("/veiculos")
public class VeiculoControl {

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping
    public List<VeiculoModel> listarVeiculos() {
        return veiculoRepo.findAll();
    }

    @PostMapping
    public void incluirVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        // Buscar o cliente no repositório
        ClienteModel cliente = clienteRepo.findById(veiculoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Criar o objeto VeiculoModel
        VeiculoModel veiculoModel = new VeiculoModel();
        veiculoModel.setModelo(veiculoDTO.getModelo());
        veiculoModel.setPlaca(veiculoDTO.getPlaca());
        veiculoModel.setPorte(veiculoDTO.getPorte());
        veiculoModel.setCliente(cliente);

        // Salvar o veículo
        veiculoRepo.save(veiculoModel);
    }

    @DeleteMapping("/{id}")
    public void deleterVeiculo(@PathVariable int id){
        veiculoRepo.deleteById(id);
    }


}
