package faeterj._5pjs.parkingsystem.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import faeterj._5pjs.parkingsystem.model.ReservaModel;
import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.model.VeiculoModel;
import faeterj._5pjs.parkingsystem.repository.ReservaRepo;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;
/*
    private Integer reserva_id;

    private LocalDateTime horarioEntrada;

    private LocalDateTime horarioSaida;

    private Double tarifa;

    private ReservaStatus reservaStatus;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private VagaModel vaga;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;
 */

@Controller
public class ReservaControl {
    
    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private VagaRepo vagaRepo;

    @GetMapping("/reservaPage")
    public String veiculoPage(@RequestParam(name = "veiculoId") String veiculo_id, Model model) {
        
        model.addAttribute("veiculoId", veiculo_id);
        model.addAttribute("reservas", reservaRepo.findAll());
        return "reservaPage";
    }
    
    @PostMapping("/insertReserva")
    public ResponseEntity<?> inserirNovaReserva(@ModelAttribute ReservaModel reserva){
        
        reservaRepo.save(?);

    }

    /*   @PostMapping("/cadastrarReserva")
    public void inserirReserva(@RequestBody ReservaDTO reservaDTO){
        VeiculoModel veiculo = veiculoRepo.findById(reservaDTO.getVeiculo_id())
        .orElseThrow(()-> new RuntimeException("veiculo nao encontrado"));

        VagaModel vagaModel = vagaRepo.findById(reservaDTO.getVaga_id())
        .orElseThrow(()-> new RuntimeException("Vaga nao encontrada"));

        ReservaModel reservaModel = new ReservaModel();
        reservaModel.setHorario_entrada(reservaDTO.getHorario_entrada());
        reservaModel.setHorario_saida(reservaDTO.getHorario_saida());
        reservaModel.setTarifa(reservaDTO.getTarifa());
        reservaModel.setReserva_status(reservaDTO.getReserva_status());
        reservaModel.setVaga(vagaModel);
        reservaModel.setVeiculo(veiculo);

        reservaRepo.save(reservaModel);

    }  */

    @DeleteMapping("/deleteReserva/{id}") 
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id){
        if (reservaRepo.existsById(id)) {
            reservaRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva deletado com sucesso!.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reserva: " + id + "not found.");
        }
    }
}
