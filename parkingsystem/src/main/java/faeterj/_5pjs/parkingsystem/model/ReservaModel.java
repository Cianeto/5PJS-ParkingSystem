package faeterj._5pjs.parkingsystem.model;

import java.time.Duration;
import java.time.LocalDateTime;
import faeterj._5pjs.parkingsystem.enums.ReservaState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel{
    private int reserva_id;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private double tarifa;
    private ReservaState reservaStatus;
    private VagaModel vagaStatus;
    private ClienteModel cliente;
    

    public double calcularTarifa(){
        double tarifa = 10;
        LocalDateTime hora1 = LocalDateTime.of(2024,6,4,10,30);
        LocalDateTime hora2 = LocalDateTime.of(2024, 6,4, 15,30);
        Duration diferenca = Duration.between(hora1, hora2);
        long horas = diferenca.toHours();
        //System.out.println(horas);
        return horas * tarifa;
    }
}