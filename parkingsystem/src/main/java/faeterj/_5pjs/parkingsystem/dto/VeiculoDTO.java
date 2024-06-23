package faeterj._5pjs.parkingsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {
    private String modelo;
    private String placa;
    private String porte;

    @JsonProperty("cliente_id")
    private Integer clienteId;
}
