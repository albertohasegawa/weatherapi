package br.com.cast.weatherapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.weatherapi.client.WeatherApiClient;
import br.com.cast.weatherapi.dto.ResultWeatherDTO;

@RestController
@RequestMapping("/")
public class WeatherController {

	@Autowired
	private WeatherApiClient client;
	
	@RequestMapping(path="buscar5")
	public List<ResultWeatherDTO> listarCinco(@RequestParam("cidade") String cidade) {
		List<ResultWeatherDTO> climas = client.fetchEvents(cidade);
		return climas;
		
	}
	
}
