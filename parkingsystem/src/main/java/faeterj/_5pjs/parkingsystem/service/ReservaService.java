package faeterj._5pjs.parkingsystem.service;

import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import faeterj._5pjs.parkingsystem.model.ReservaModel;
import faeterj._5pjs.parkingsystem.repository.ReservaRepo;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@Service
public class ReservaService {
    @Autowired
    ReservaRepo reservaRepo;
    @Autowired
    VagaRepo vagaRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // TARIFA (
    public Double calcularTarifa(LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        double tarifaPorHora = 10.00; // R$ 10,00
        double tarifaMinima = 10.00;
        
        Duration diferenca = Duration.between(horaEntrada, horaSaida);
        double horas = diferenca.toMinutes() / 60.0; 
        double tarifaCalculada = Math.ceil(horas) * tarifaPorHora;
    
        return Math.max(tarifaCalculada, tarifaMinima);
    }
    // )

    // FINALIZAR RESERVA (
    @Transactional
    public void concluirReserva(ReservaModel reserva){

        LocalDateTime horarioSaida = LocalDateTime.now();
        double valorTarifa = calcularTarifa(reserva.getHorarioEntrada(), horarioSaida);
        reserva.setHorarioSaida(horarioSaida);
        reserva.setTarifa(valorTarifa);
        reserva.setReservaStatus(ReservaStatus.FINALIZADO);
        reservaRepo.save(reserva);
        
        String query = "UPDATE tb_vagas SET vaga_status = 'LIVRE' WHERE vaga_id = ?;";
        
        jdbcTemplate.update(query, reserva.getVagaId());
        
    }
    // )
}   
