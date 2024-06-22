package faeterj._5pjs.parkingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.ClienteModel;

@Repository
public interface ClienteRepo extends JpaRepository<ClienteModel, Integer>{
    
	Optional<ClienteModel> findByCpf(String cpf); // SELECT * FROM tb_colaboradores WHERE cpf = ??;
}
