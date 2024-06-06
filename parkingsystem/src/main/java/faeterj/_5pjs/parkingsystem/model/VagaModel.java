package faeterj._5pjs.parkingsystem.model;

import faeterj._5pjs.parkingsystem.enums.VagaState;
import lombok.Getter;

@Getter
public class VagaModel {
    private int id; // id da tb_vaga
    private VagaState status;

}