package br.com.cast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {

	
	private Double temp_min;
	private Double temp_max;
	@JsonProperty("pressure")
	private Double pressao;
	@JsonProperty("humidity")
	private Integer umidade;
	
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public Double getPressao() {
		return pressao;
	}
	public void setPressao(Double pressao) {
		this.pressao = pressao;
	}
	public Integer getUmidade() {
		return umidade;
	}
	public void setUmidade(Integer umidade) {
		this.umidade = umidade;
	}

	
	
}
