package faeterj._5pjs.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import faeterj._5pjs.parkingsystem.enums.VagaStatus;
import faeterj._5pjs.parkingsystem.model.VagaModel;
import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@Service
public class VagaService {
    @Autowired
    VagaRepo vagaRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ENCONTRAR PRIMEIRA VAGA LIVRE (
    @Transactional
    public Integer verificarPrimeiraVagaLivre(){
        Pageable firstResult = PageRequest.of(0, 1);
        Page<VagaModel> vagasLivres = vagaRepo.findFirstByVagaStatus(VagaStatus.LIVRE, firstResult);
        if (!vagasLivres.isEmpty()) {
            VagaModel vagaLivre = vagasLivres.getContent().get(0);
            vagaLivre.setVagaStatus(VagaStatus.OCUPADO);
            vagaRepo.save(vagaLivre);
            return vagaLivre.getVagaId();
        } else {
            return null;
        }
    }
    // )

    public void liberarVaga(Integer vagaId){
        String query = "UPDATE tb_vagas SET vaga_status = 'LIVRE' WHERE vaga_id = ?;";
        jdbcTemplate.update(query, vagaId);
    }

}
