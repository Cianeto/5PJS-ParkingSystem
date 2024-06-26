package faeterj._5pjs.parkingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.VagaModel;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

@Repository
public interface VagaRepo extends JpaRepository<VagaModel, Integer>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT v FROM VagaModel v WHERE v.vaga_status = 'LIVRE' ORDER BY v.vaga_id ASC")
    @Transactional
    Optional<VagaModel> findFirstByVagaStatusLivre();
}
