package faeterj._5pjs.parkingsystem.model;

import java.time.Duration;
import java.time.LocalDateTime;

import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_reservas")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reserva_id;

    // MUDAR NOME DE RESERVA PRA TICKET DEPENDENDO
    
    private LocalDateTime horario_entrada;
    
    private LocalDateTime horario_saida;

    private Double tarifa;

    @Enumerated(EnumType.STRING)
    @Column(name = "reserva_status")
    private ReservaStatus reserva_status;

    /* @ManyToOne
    @JoinColumn(name = "vaga_id")
    private VagaModel vaga; */

    private Integer vagaId;

    /* @OneToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo; */

    private Integer veiculoId;


    
}