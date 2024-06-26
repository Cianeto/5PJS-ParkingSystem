package faeterj._5pjs.parkingsystem.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faeterj._5pjs.parkingsystem.model.VeiculoModel;

@Repository
public interface VeiculoRepo extends JpaRepository<VeiculoModel, Integer>{
    // SELECT * FROM tb_veiculos WHERE placa = ??;
    Optional<VeiculoModel> findByPlaca(String placa);

    // SELECT * FROM tb_veiculos WHERE cliente_id = ??;
    List<VeiculoModel> findByClienteId(Integer clienteId);
}
