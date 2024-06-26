package faeterj._5pjs.parkingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.ClienteModel;

@Repository
public interface ClienteRepo extends JpaRepository<ClienteModel, Integer>{
    // SELECT * FROM tb_clientes WHERE cpf = ??;
	Optional<ClienteModel> findByCpf(String cpf);
}
