package com.github.estacionamento.controllers;

import com.github.estacionamento.dtos.VagaDto;
import com.github.estacionamento.models.VagasModel;
import com.github.estacionamento.services.VagasServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vagas-estacionamento")
public class VagaController {

		final VagasServices vagasServices;

		public VagaController(VagasServices vagasServices) {
				this.vagasServices = vagasServices;
		}
		@PostMapping
		public ResponseEntity<Object>registroDaVaga(@RequestBody @Valid VagaDto vagaDto){
				if(vagasServices.existePorPlacaDeCarro(vagaDto.getPlacaDoCarro())){
						return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Placa já cadastrada.");
				}
				if(vagasServices.existePorNumeroDaVaga(vagaDto.getNumeroDaVaga())){
						return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Vaga já ocupada!!");
				}
				if(vagasServices.existePorEndereco(vagaDto.getEndereco())) {
						return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro:Limite de vaga excedido.");
				}
				if(vagasServices.existePorDonodaVaga(vagaDto.getDonoDaVaga())) {
						return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro:Esta pessoa já possui uma vaga em seu nome .");
				}
				VagasModel vagasModel = new VagasModel();
				BeanUtils.copyProperties(vagaDto, vagasModel);
				vagasModel.setDataDoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
				return ResponseEntity.status(HttpStatus.CREATED).body(vagasServices.save(vagasModel));
		}
		@GetMapping
		public ResponseEntity<List<VagasModel>> getAllVagas(){
				return ResponseEntity.status(HttpStatus.OK).body(vagasServices.busqueTodos());
		}
		@GetMapping("/{id}")
		public ResponseEntity<Object>getOneVagas(@PathVariable(value = "id")UUID id){
				Optional<VagasModel > vagasModelOptional = vagasServices.findById(id);
				if (!vagasModelOptional.isPresent()){
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
				}
				return ResponseEntity.status(HttpStatus.OK).body(vagasModelOptional.get());
		}
}

