package faeterj._5pjs.parkingsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_veiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veiculo_id;

    private String modelo;

    @Column(unique = true)
    private String placa;

    private String porte;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
}