package faeterj._5pjs.parkingsystem.model;

import faeterj._5pjs.parkingsystem.enums.VagaStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_vagas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VagaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vaga_id;

    
    private VagaStatus status;
}