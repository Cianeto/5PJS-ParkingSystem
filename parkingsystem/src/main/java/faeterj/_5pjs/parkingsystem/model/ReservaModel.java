package faeterj._5pjs.parkingsystem.model;

import java.time.Duration;
import java.time.LocalDateTime;
import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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