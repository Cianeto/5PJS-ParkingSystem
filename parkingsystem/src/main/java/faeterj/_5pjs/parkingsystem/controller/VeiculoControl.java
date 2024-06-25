package faeterj._5pjs.parkingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return "veiculoPage";
    }

    @PostMapping("/veiculo")
    public String submitCliente(@RequestParam(name = "clienteId") String clienteId, @ModelAttribute VeiculoDTO veiculoDTO) {
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
    }
}
