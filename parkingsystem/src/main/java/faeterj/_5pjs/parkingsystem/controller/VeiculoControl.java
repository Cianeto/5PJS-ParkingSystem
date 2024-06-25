package faeterj._5pjs.parkingsystem.controller;

import java.util.List;
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

import faeterj._5pjs.parkingsystem.dto.VeiculoDTO;
import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.model.VeiculoModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;

@Controller
public class VeiculoControl {

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ClienteRepo clienteRepo;


    @GetMapping("/veiculoPage")
    public String veiculoPage(@RequestParam(name = "clienteId") String clienteId, Model model) {
        // Optionally, fetch the cliente or related information using clienteId
        model.addAttribute("clienteId", clienteId);
        model.addAttribute("veiculos", veiculoRepo.findAll());
        return "veiculoPage";
    }

    /* @PostMapping("/insertVeiculo")
    public String inserirNovoVeiculo(@RequestParam(name = "clienteId") String clienteId, @ModelAttribute VeiculoDTO veiculoDTO) {
        ClienteModel cliente = clienteRepo.findById(Integer.parseInt(clienteId))
        .orElseThrow(() -> new RuntimeException("Cliente nao encontrado!"));
        // Save the cliente object to the database
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setPorte(veiculoDTO.getPorte());
        veiculo.setCliente(cliente);
        veiculoRepo.save(veiculo);

        return "redirect:/";
    } */

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

    @DeleteMapping("/deleteVeiculo/{id}") 
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id){
        if (clienteRepo.existsById(id)) {
            clienteRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Veiculo deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("veiculo_id: " + id + "not found.");
        }
    }
}
