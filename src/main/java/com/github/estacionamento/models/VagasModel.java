package com.github.estacionamento.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_Vaga_Disponivel")
public class VagasModel implements Serializable {
		public static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id;
		@Column(nullable = false, unique = true, length = 3)
		private String numeroDaVaga;
		@Column(nullable = false, unique = true, length = 7)
		private String placaDoCarro;
		@Column(nullable = false, length = 20)
		private String marcaDoCarro;
		@Column(nullable = false, length = 20)
		private String modeloDoCarro;
		@Column(nullable = false, length = 11)
		private String corDoCarro;
		@Column(nullable = false, unique = true, length = 20)
		private String donoDaVaga;
		@Column(nullable = false)
		private LocalDateTime dataDoRegistro;
		@Column(nullable = false, unique = true, length = 4)
		private String endereco;

		public static long getSerialVersionUID() {
				return serialVersionUID;
		}

		public UUID getId() {
				return id;
		}

		public void setId(UUID id) {
				this.id = id;
		}

		public String getNumeroDaVaga() {
				return numeroDaVaga;
		}

		public void setNumeroDaVaga(String numeroDaVaga) {
				this.numeroDaVaga = numeroDaVaga;
		}

		public String getPlacaDoCarro() {
				return placaDoCarro;
		}

		public void setPlacaDoCarro(String placaDoCarro) {
				this.placaDoCarro = placaDoCarro;
		}

		public String getMarcaDoCarro() {
				return marcaDoCarro;
		}

		public void setMarcaDoCarro(String marcaDoCarro) {
				this.marcaDoCarro = marcaDoCarro;
		}

		public String getModeloDoCarro() {
				return modeloDoCarro;
		}

		public void setModeloDoCarro(String modeloDoCarro) {
				this.modeloDoCarro = modeloDoCarro;
		}

		public String getCorDoCarro() {
				return corDoCarro;
		}

		public void setCorDoCarro(String corDoCarro) {
				this.corDoCarro = corDoCarro;
		}

		public String getDonoDaVaga() {
				return donoDaVaga;
		}

		public void setDonoDaVaga(String donoDaVaga) {
				this.donoDaVaga = donoDaVaga;
		}

		public LocalDateTime getDataDoRegistro() {
				return dataDoRegistro;
		}

		public void setDataDoRegistro(LocalDateTime dataDoRegistro) {
				this.dataDoRegistro = dataDoRegistro;
		}

		public String getEndereco() {
				return endereco;
		}

		public void setEndereco(String endereco) {
				this.endereco = endereco;
		}
}
