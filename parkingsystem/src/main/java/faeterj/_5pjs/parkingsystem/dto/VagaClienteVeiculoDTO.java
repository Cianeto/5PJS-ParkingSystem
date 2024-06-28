package faeterj._5pjs.parkingsystem.dto;

import faeterj._5pjs.parkingsystem.model.ClienteModel;
import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.model.VeiculoModel;

public record VagaClienteVeiculoDTO(VagaModel vaga, VeiculoModel veiculo, ClienteModel cliente) { 

}
