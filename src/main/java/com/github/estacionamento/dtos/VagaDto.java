package com.github.estacionamento.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VagaDto {

		@NotBlank
		private String numeroDaVaga;
		@NotBlank
		@Size(max = 7,min = 7)
		private String placaDoCarro;
		@NotBlank
		private String marcaDoCarro;
		@NotBlank
		private String modeloDoCarro;
		@NotBlank
		private String corDoCarro;
		@NotBlank
		private String donoDaVaga;
		@NotBlank
		@Size(max = 4,min = 4)
		private String endereco;

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

		public String getEndereco() {
				return endereco;
		}

		public void setEndereco(String endereco) {
				this.endereco = endereco;
		}
}
