package br.com.cast.weatherapi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.weatherapi.client.WeatherApiClient;
import br.com.cast.weatherapi.dto.ResultWeatherDTO;
import br.com.cast.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/")
public class WeatherController {

	@Autowired
	private WeatherApiClient client;

	@Autowired
	private WeatherService ws;

	@RequestMapping(path = "buscar5", method = RequestMethod.GET)
	public List<ResultWeatherDTO> listarCinco(@RequestParam("cidade") String cidade,
			@RequestParam("hora") Integer hora) {

		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 4);
		dt = c.getTime();
		String dataString = cidade + " - " + dt.getDate() + "-"
		+ (dt.getMonth() + 1) + "-" + (dt.getYear() + 1900);
		System.out.println(dt);
		System.out.println(dataString);
		boolean tem = ws.buscarPorCidadeHora(dataString);
		
		if(!tem) {
			ws.deletarDaCidade(cidade);
			List<ResultWeatherDTO> climas = client.fetchEvents(cidade, hora);
			for (ResultWeatherDTO rwdto : climas) {
				String dataaqui = cidade + " - " + rwdto.getDataatual().getDate() + "-"
						+ (rwdto.getDataatual().getMonth() + 1) + "-" + (rwdto.getDataatual().getYear() + 1900);
				rwdto.setCidadeHora(dataaqui);
				System.out.println(rwdto.getCidadeHora());
				ws.inserir(rwdto);
			}
			System.out.println("inseriu no sistema...");
			return climas;
			
		}
			
		System.out.println("já tinha no sistema");
		return ws.buscarCincoDaCidade(cidade);


	}

	@RequestMapping(path = "inserir", method = RequestMethod.POST)
	public String inserirDados(@RequestBody ResultWeatherDTO rwdto) {
		ws.inserir(rwdto);
		return "sucesso";

	}

}
