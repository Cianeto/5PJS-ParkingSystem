package faeterj._5pjs.parkingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.ReservaModel;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaModel, Integer>{

    List<ReservaModel> findByVeiculoId(Integer clienteId);
   // List<ReservaModel> findByReservaStatus(String reservaStatus);

}
