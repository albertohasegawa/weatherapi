package br.com.cast.weatherapi.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.weatherapi.dto.ResultWeatherDTO;
import br.com.cast.weatherapi.dto.WeatherDTO;
import br.com.cast.weatherapi.dto.WeatherDataDTO;

@Component
public class WeatherApiClient {

	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&units=metric&mode=json&appid={appid}&lang=pt";
	private static final String APPID = "538dc37c7e01a8c92c7ec575a3bde244";
	
	private final RestTemplate rt;
	
	public WeatherApiClient(RestTemplateBuilder rtb) {
		this.rt = rtb.build();
	}
	
	public List<ResultWeatherDTO> fetchEvents(String cidade) {
		String appId = APPID;
		WeatherDTO resultados = this.rt.getForObject(WEATHER_URL, WeatherDTO.class, cidade, appId);
		List<ResultWeatherDTO> lista = new ArrayList<>();
		Map<String, String> mapa = new HashMap<>();
		
		for (WeatherDataDTO wdtos : resultados.getList()) {
			String dia = wdtos.getData().substring(8, 9);
			if(!mapa.containsKey(dia)) {
			ResultWeatherDTO rwdto = new ResultWeatherDTO();
			rwdto.setData(wdtos.getData());
			rwdto.setDescricao_main(wdtos.getDescricao()[0].getMain());
			rwdto.setIcone(wdtos.getDescricao()[0].getIcon());
			rwdto.setPressao(wdtos.getMain().getPressao());
			rwdto.setTemp_max(wdtos.getMain().getTemp_max());
			rwdto.setTemp_min(wdtos.getMain().getTemp_min());
			rwdto.setUmidade(wdtos.getMain().getUmidade());
			rwdto.setVelocidade_vento(wdtos.getVento().getVelocidade());
			lista.add(rwdto);
			}
			
//			resultados.getList().get(0).getData().substring(beginIndex, endIndex)
			
			
		}
		
		return lista;
	}
	
}
