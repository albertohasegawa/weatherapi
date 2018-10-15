package br.com.cast.weatherapi.dto;

import java.util.ArrayList;
import java.util.List;

public class WeatherDTO {

	private List<WeatherDataDTO> list = new ArrayList<>();

	public List<WeatherDataDTO> getList() {
		return list;
	}

	public void setList(List<WeatherDataDTO> list) {
		this.list = list;
	}
	
}
