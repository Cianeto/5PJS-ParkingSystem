package faeterj._5pjs.parkingsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_veiculos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veiculo_id;

    private String modelo;

    @Column(unique = true, nullable = false)
    private String placa;

    private String porte;

    /* @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente; */
    private Integer clienteId;

}