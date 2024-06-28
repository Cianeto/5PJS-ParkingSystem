package faeterj._5pjs.parkingsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.enums.ReservaStatus;
import faeterj._5pjs.parkingsystem.model.ReservaModel;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaModel, Integer>{

    List<ReservaModel> findByVeiculoId(Integer clienteId);

    Optional<ReservaModel> findByVagaIdAndReservaStatus(Integer vagaId, ReservaStatus reservaStatus);

    List<ReservaModel> findByVeiculoIdAndReservaStatus(Integer veiculoId, ReservaStatus reservaStatus);

    Optional<ReservaModel> findFirstByVeiculoIdAndReservaStatus(Integer veiculoId, ReservaStatus reservaStatus);

}
