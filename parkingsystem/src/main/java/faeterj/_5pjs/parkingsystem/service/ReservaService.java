package faeterj._5pjs.parkingsystem.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.repository.ReservaRepo;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@Service
public class ReservaService {
    @Autowired
    ReservaRepo reservaRepo;
    @Autowired
    VagaRepo vagaRepo;

    
    /* public Double calcularTarifa(LocalDateTime horaSaida){
        Double tarifa = 10.00;
        LocalDateTime horaEntrada = LocalDateTime.now();
        Duration diferenca = Duration.between(horaEntrada, horaSaida);
        long horas = diferenca.toHours();
        //System.out.println(horas);
        return (horas * tarifa);
    } */
    
    // TARIFA (
    public Double calcularTarifa(LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        double tarifaPorHora = 10.00; // R$ 10,00
 
        Duration diferenca = Duration.between(horaEntrada, horaSaida);
        /* if (diferenca.isNegative()) {
            throw new IllegalArgumentException("Hora de saída deve ser após a hora de entrada.");
        } */
        double horas = diferenca.toMinutes() / 60.0; 
        double tarifaCalculada = Math.ceil(horas) * tarifaPorHora;
    
        return tarifaCalculada;
    }
    // )

    // VAGA_ID (
    @Transactional
    public Integer verificarPrimeiraVagaLivre(){
        Optional<VagaModel> vaga = vagaRepo.findFirstByVagaStatusLivre();
        
        if (vaga.isPresent()) {
            VagaModel vagaLivre = vaga.get();
            vagaLivre.setStatus(null);
            vagaRepo.save(vagaLivre);
            return vagaLivre.getVagaId();
        } else {
            return null;
        }

        return 0;
    }
    
    // )
}   
