package faeterj._5pjs.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.ReservaModel;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaModel, Integer>{
    
}
