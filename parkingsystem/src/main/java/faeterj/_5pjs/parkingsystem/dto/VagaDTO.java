package faeterj._5pjs.parkingsystem.dto;

import faeterj._5pjs.parkingsystem.enums.VagaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VagaDTO {
    private VagaStatus vagaStatus;
}
