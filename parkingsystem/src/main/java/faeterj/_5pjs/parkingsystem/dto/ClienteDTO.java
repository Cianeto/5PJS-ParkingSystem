package faeterj._5pjs.parkingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Integer cliente_id;
    private String nome;
    private String cpf;
    private String telefone;
}
