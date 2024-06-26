package faeterj._5pjs.parkingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.enums.VagaStatus;
import faeterj._5pjs.parkingsystem.model.VagaModel;

@Repository
public interface VagaRepo extends JpaRepository<VagaModel, Integer>{

    @Query("SELECT v FROM VagaModel v WHERE v.vagaStatus = :status ORDER BY v.vagaId ASC")
    Optional<VagaModel> findFirstByVagaStatus(@Param("status") VagaStatus vagaStatus);
    //Optional<VagaModel> findFirstByStatus(String status);
}
