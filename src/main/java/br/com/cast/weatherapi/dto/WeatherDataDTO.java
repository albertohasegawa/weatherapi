package br.com.cast.weatherapi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {

	@JsonProperty("main")
	private WeatherMainDTO main;
	@JsonProperty("weather")
	private WeatherDescricaoDTO[] descricao;
	@JsonProperty("wind")
	private WeatherVentoDTO vento;
	@JsonProperty("dt_txt")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date data;
	
	public WeatherMainDTO getMain() {
		return main;
	}
	public void setMain(WeatherMainDTO main) {
		this.main = main;
	}

	

	public WeatherDescricaoDTO[] getDescricao() {
		return descricao;
	}
	public void setDescricao(WeatherDescricaoDTO[] descricao) {
		this.descricao = descricao;
	}
	public WeatherVentoDTO getVento() {
		return vento;
	}
	public void setVento(WeatherVentoDTO vento) {
		this.vento = vento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}


}
