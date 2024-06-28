package faeterj._5pjs.parkingsystem.model;

import java.time.LocalDateTime;

import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
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
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservaId;

    private LocalDateTime horarioEntrada;

    private LocalDateTime horarioSaida;

    private Double tarifa;

    @Enumerated(EnumType.STRING)
    private ReservaStatus reservaStatus;

    private String commentary;

    private Integer vagaId;

    private Integer veiculoId;

    public ReservaModel(LocalDateTime horarioEntrada, ReservaStatus reservaStatus, Integer vagaId, Integer veiculoId) {
        this.horarioEntrada = horarioEntrada;
        this.reservaStatus = reservaStatus;
        this.vagaId = vagaId;
        this.veiculoId = veiculoId;
    }
}