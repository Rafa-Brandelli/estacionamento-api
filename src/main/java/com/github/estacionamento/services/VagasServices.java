package com.github.estacionamento.services;

import com.github.estacionamento.models.VagasModel;
import com.github.estacionamento.repositories.VagasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}