package br.com.cast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherVentoDTO {

	
	@JsonProperty("speed")
	private Double velocidade;

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}


	
	
}
