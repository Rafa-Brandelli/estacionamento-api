package com.github.estacionamento.repositories;

import com.github.estacionamento.models.VagasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VagasRepository extends JpaRepository<VagasModel, UUID> {

		boolean existsByPlacaDoCarro(String placaDoCarro);
		boolean existsByNumeroDaVaga(String numeroDaVaga);
		boolean existsByEndereco(String endereco);
}
