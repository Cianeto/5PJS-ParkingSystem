package faeterj._5pjs.parkingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private int cliente_id;
    private String cpf;
    private String nome;
    private String telefone;
    private VeiculoModel veiculo;
}