package faeterj._5pjs.parkingsystem.dto;

import java.time.LocalDateTime;

import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReservaDTO {

    private LocalDateTime horario_entrada;
    private LocalDateTime horario_saida;
    private ReservaStatus reserva_status;
    private Double tarifa;

    private Integer vaga_id;
    private Integer veiculo_id;
}
