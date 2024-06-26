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
import org.springframework.web.bind.annotation.RequestParam;

import faeterj._5pjs.parkingsystem.model.VeiculoModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;

@Controller
public class VeiculoControl {

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    // LISTAR TODOS VEICULOS DO CLIENTE ACESSADO
    @GetMapping("/veiculoPage")
    public String veiculoPage(@RequestParam(name = "clienteId") String clienteId, Model model){
        Integer cliente_id = Integer.parseInt(clienteId);
        model.addAttribute("cliente", clienteRepo.findById(cliente_id).get());
        model.addAttribute("veiculos", veiculoRepo.findByClienteId(cliente_id));
        return "veiculopage";
    }

    // INSERIR VEICULO
    @PostMapping("/insertVeiculo")
    public ResponseEntity<?> inserirNovoVeiculo(@ModelAttribute VeiculoModel veiculo){
        Optional<VeiculoModel> existingVeiculo = veiculoRepo.findByPlaca(veiculo.getPlaca());
        if (existingVeiculo.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Veiculo com placa " + veiculo.getPlaca() + " já existe.");
        } else {
            veiculoRepo.save(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
        }
    }

    // DELETAR VEICULO
    @DeleteMapping("/deleteVeiculo/{id}") 
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id){
        if (veiculoRepo.existsById(id)) {
            veiculoRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Veiculo deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("veiculo_id: " + id + "not found.");
        }
    }
}
