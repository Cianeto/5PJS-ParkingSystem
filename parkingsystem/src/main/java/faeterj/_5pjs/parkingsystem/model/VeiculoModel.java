package faeterj._5pjs.parkingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoModel {
    private int veiculo_id;
    private String placa;
    private String modelo;
    private String porte;
}