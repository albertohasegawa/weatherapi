package br.com.cast.weatherapi.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.weatherapi.dto.ResultWeatherDTO;
import br.com.cast.weatherapi.dto.WeatherDTO;
import br.com.cast.weatherapi.dto.WeatherDataDTO;

@Component
public class WeatherApiClient {

	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&units=metric&mode=json&appid={appid}&lang=pt";
	private static final String APPID = "538dc37c7e01a8c92c7ec575a3bde244";
//	private static final Integer MEIA_NOITE = 0;
//	private static final Integer TRES_AM = 1;
//	private static final Integer SEIS_AM = 2;
//	private static final Integer NOVE_AM = 3;
//	private static final Integer MEIO_DIA = 4;
//	private static final Integer TRES_PM = 5;
//	private static final Integer SEIS_PM = 6;
//	private static final Integer NOVE_PM = 7;
	
	private static final String HORA[] = new String[] {
			"00:00:00", //   INDICE 0
			"03:00:00", //   INDICE 1
			"06:00:00", //	 INDICE 2
			"09:00:00", //	 INDICE 3 
			"12:00:00", //	 INDICE 4
			"15:00:00", //	 INDICE 5
			"18:00:00", //	 INDICE 6
			"21:00:00"  //	 INDICE 7
		};
	
	
	private final RestTemplate rt;
	
	public WeatherApiClient(RestTemplateBuilder rtb) {
		this.rt = rtb.build();
	}
	
	public List<ResultWeatherDTO> fetchEvents(String cidade, Integer horario) {
		String appId = APPID;
		WeatherDTO resultados = this.rt.getForObject(WEATHER_URL, WeatherDTO.class, cidade, appId);
		List<ResultWeatherDTO> lista = new ArrayList<>();
		List<ResultWeatherDTO> listafiltrada = new ArrayList<>();
		
		
		
		for (WeatherDataDTO wdtos : resultados.getList()) {

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
			
			
//			resultados.getList().get(0).getData().substring(beginIndex, endIndex)
		}
		for (ResultWeatherDTO result : lista) {
			if(result.getData().contains(HORA[horario])) 
				listafiltrada.add(result);				
		}
		
		
		return listafiltrada;
	}
	
}
