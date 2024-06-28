package faeterj._5pjs.parkingsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import faeterj._5pjs.parkingsystem.dto.ReservaDTO;
import faeterj._5pjs.parkingsystem.dto.VagaClienteVeiculoDTO;
import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.model.ReservaModel;
import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.model.VeiculoModel;
import faeterj._5pjs.parkingsystem.repository.ClienteRepo;
import faeterj._5pjs.parkingsystem.repository.ReservaRepo;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;
import faeterj._5pjs.parkingsystem.repository.VeiculoRepo;

@Controller
public class VagaControl {
    @Autowired
    private VagaRepo vagaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ReservaRepo reservaRepo;

    // LISTA DE RESERVAS E VAGAS
    @GetMapping("/lista_vagas_reservas")
    public String vagaPage(Model model) {

        List<ReservaDTO> reservaDTOs = new ArrayList<>();

        List<VeiculoModel> veiculos = veiculoRepo.findAll();

        for (VeiculoModel veiculo : veiculos) {

            List<ReservaModel> reservas = reservaRepo.findByVeiculoIdAndReservaStatus(veiculo.getVeiculoId(), ReservaStatus.EM_ANDAMENTO);

            for (ReservaModel reserva : reservas) {
                
                reservaDTOs.add(new ReservaDTO(reserva, veiculo.getPlaca()));
            }
        }
        List<VagaClienteVeiculoDTO> vagaDtos = new ArrayList<>();
        List<VagaModel> vagas = vagaRepo.findAll();

        for(VagaModel vaga : vagas){
            System.out.println(vaga);
            Optional<ReservaModel> reserva = reservaRepo.findByVagaIdAndReservaStatus(vaga.getVagaId(), ReservaStatus.EM_ANDAMENTO);
            if(reserva.isPresent()){
                Optional<VeiculoModel> veiculo = veiculoRepo.findById(reserva.get().getVeiculoId());
                if(veiculo.isPresent()){
                    Optional<ClienteModel> cliente = clienteRepo.findById(veiculo.get().getClienteId());
                    if(cliente.isPresent()){
                        vagaDtos.add(new VagaClienteVeiculoDTO(vaga, veiculo.get(), cliente.get()));
                    }
                }
            }
        }

        model.addAttribute("reservas", reservaDTOs);
        model.addAttribute("vagas", vagaDtos);

        return "lista_vagas_reservas";
    }
}
