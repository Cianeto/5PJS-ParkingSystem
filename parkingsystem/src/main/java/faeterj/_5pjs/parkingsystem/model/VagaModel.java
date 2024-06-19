package faeterj._5pjs.parkingsystem.model;

import faeterj._5pjs.parkingsystem.enums.VagaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VagaModel {
    private int vaga_id;
    private VagaStatus status;
}