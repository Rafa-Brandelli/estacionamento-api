package com.github.estacionamento.services;

import com.github.estacionamento.models.VagasModel;
import com.github.estacionamento.repositories.VagasRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VagasServices {

		final VagasRepository vagasRepository;

		public VagasServices(VagasRepository vagasRepository) {
				this.vagasRepository = vagasRepository;
		}

		@Transactional
		public VagasModel save(VagasModel vagasModel) {
				return vagasRepository.save(vagasModel);
		}

		public boolean existePorPlacaDeCarro(String placaDoCarro) {
				return vagasRepository.existsByPlacaDoCarro(placaDoCarro);
		}

		public boolean existePorNumeroDaVaga(String numeroDaVaga) {
				return vagasRepository.existsByNumeroDaVaga(numeroDaVaga);
		}

		public boolean existePorEndereco(String endereco) {
				return vagasRepository.existsByEndereco(endereco);
		}

		public boolean existePorDonodaVaga(String donoDaVaga) {
				return vagasRepository.existsByDonoDaVaga(donoDaVaga);
		}
		public List<VagasModel> busqueTodos(){
				return vagasRepository.findAll();
		}

		public Optional<VagasModel> findById(UUID id) {
				return vagasRepository.findById(id);
		}
		@Transactional
		public void delete(VagasModel vagasModel) {
				vagasRepository.delete(vagasModel);
		}
}