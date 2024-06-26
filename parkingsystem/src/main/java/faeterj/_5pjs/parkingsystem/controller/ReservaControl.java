package faeterj._5pjs.parkingsystem.controller;
import java.time.LocalDateTime;
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

import faeterj._5pjs.parkingsystem.enums.VagaStatus;
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
import faeterj._5pjs.parkingsystem.service.ReservaService;

@Controller
public class ReservaControl {
    
    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private VagaRepo vagaRepo;

    @Autowired
    private ReservaService reservaServ;

    @GetMapping("/reservaPage")
    public String veiculoPage(@RequestParam(name = "veiculoId") String veiculo_id, Model model) {
        
        model.addAttribute("veiculoId", veiculo_id);
        model.addAttribute("reservas", reservaRepo.findAll());
        return "reservaPage";
    }
    
    @PostMapping("/insertReserva")
    public ResponseEntity<?> inserirNovaReserva(@ModelAttribute ReservaModel reserva){
        Integer vaga = reservaServ.verificarPrimeiraVagaLivre();
        if(vaga == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todas vagas estão ocupadas.");
        }
        LocalDateTime horarioEntrada = LocalDateTime.now();
        LocalDateTime horarioSaida = reserva.getHorario_saida();
        reserva.setHorario_entrada(horarioEntrada);
        reserva.setTarifa(reservaServ.calcularTarifa(horarioEntrada, horarioSaida));
        reserva.setHorario_saida(horarioSaida);
        /* reserva.setReserva_status(?); */
        reserva.setVagaId(vaga);
        reservaRepo.save(reserva);
        return ResponseEntity.status(HttpStatus.FOUND).body("Vaga livre encontrada.");
    }

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
