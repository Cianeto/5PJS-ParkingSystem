package faeterj._5pjs.parkingsystem.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;
import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import faeterj._5pjs.parkingsystem.model.ReservaModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;
import faeterj._5pjs.parkingsystem.repository.ReservaRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;
import faeterj._5pjs.parkingsystem.service.ReservaService;
import faeterj._5pjs.parkingsystem.service.VagaService;

@Controller
public class ReservaControl {

    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ReservaService reservaServ;

    @Autowired
    private VagaService vagaServ;
    
    
    /* @GetMapping("/veiculoPage")
    public String veiculoPage(@RequestParam(name = "clienteId") String clienteId, Model model) {
        Integer cliente_id = Integer.parseInt(clienteId);
        model.addAttribute("cliente", clienteRepo.findById(cliente_id).get());
        model.addAttribute("veiculos", veiculoRepo.findByClienteId(cliente_id));
        model.addAttribute("reservas", reservaRepo.findByClienteId(cliente_id));
        return "veiculoPage";
    } */

    @PostMapping("/insertReserva")
    public ResponseEntity<?> inserirNovaReserva(@RequestParam(name = "veiculoId") Integer veiculoId) {
        Integer vaga = vagaServ.verificarPrimeiraVagaLivre();
        if (vaga == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todas as vagas estão ocupadas.");
        }
        List<ReservaModel> reservas = reservaRepo.findByVeiculoId(veiculoId);
        for (ReservaModel valor : reservas){
            if (valor.getReservaStatus() == ReservaStatus.EM_ANDAMENTO){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo ainda está reservad");
            }
        }

        ReservaModel reserva = new ReservaModel(LocalDateTime.now(), ReservaStatus.EM_ANDAMENTO, vaga, veiculoId);

        reservaRepo.save(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva criada com sucesso. Vaga livre encontrada.");
    }

    @PostMapping("/confirmarPagamento")
    public ResponseEntity<?> finalizarReserva(@RequestParam(name = "reservaId") Integer reservaId) {
        Optional<ReservaModel> optReserva = reservaRepo.findById(reservaId);
        if (!optReserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada.");
        }

        ReservaModel reserva = optReserva.get();
        reservaServ.concluirReserva(reserva);

        return ResponseEntity.ok("Pagamento confirmado.");
    }

    @DeleteMapping("/deleteReserva/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id) {
        if (reservaRepo.existsById(id)) {
            reservaRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva deletado com sucesso!.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reserva: " + id + "not found.");
        }
    }
}
