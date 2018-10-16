package br.com.cast.weatherapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.weatherapi.dto.ResultWeatherDTO;
import br.com.cast.weatherapi.entidade.Weather;
import br.com.cast.weatherapi.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository wr;
	
	public List<ResultWeatherDTO> buscarCincoDaCidade(String cidade) {
		List<Weather> lista =  wr.buscarCincoDaCidade(cidade);
		List<ResultWeatherDTO> result = new ArrayList<>();
		for (Weather weather : lista) {
			ResultWeatherDTO rwdto = new ResultWeatherDTO();
			rwdto.setDescricao_main(weather.getDescricao_main());
			rwdto.setIcone(weather.getIcone());
			rwdto.setPressao(weather.getPressao());
			rwdto.setTemp_max(weather.getTemp_max());
			rwdto.setTemp_min(weather.getTemp_min());
			rwdto.setUmidade(weather.getUmidade());
			rwdto.setVelocidade_vento(weather.getVelocidade_vento());
			rwdto.setCidadeHora(weather.getCidadeHora());
			rwdto.setCidade(weather.getCidade());
			
			result.add(rwdto);
		}
		
		return result;
	}
	
	public void inserir(ResultWeatherDTO rwdto) {
		Weather weather = new Weather();
		weather.setDescricao_main(rwdto.getDescricao_main());
		weather.setIcone(rwdto.getIcone());
		weather.setPressao(rwdto.getPressao());
		weather.setTemp_max(rwdto.getTemp_max());
		weather.setTemp_min(rwdto.getTemp_min());
		weather.setUmidade(rwdto.getUmidade());
		weather.setVelocidade_vento(rwdto.getVelocidade_vento());
		weather.setCidadeHora(rwdto.getCidadeHora());
		weather.setDataatual(rwdto.getDataatual());
		weather.setCidade(rwdto.getCidade());
		wr.inserir(weather);
	}
	public void deletar(ResultWeatherDTO rwdto) {
		Weather weather = new Weather();
		weather.setDescricao_main(rwdto.getDescricao_main());
		weather.setIcone(rwdto.getIcone());
		weather.setPressao(rwdto.getPressao());
		weather.setTemp_max(rwdto.getTemp_max());
		weather.setTemp_min(rwdto.getTemp_min());
		weather.setUmidade(rwdto.getUmidade());
		weather.setVelocidade_vento(rwdto.getVelocidade_vento());
		weather.setCidadeHora(rwdto.getCidadeHora());
		weather.setCidade(rwdto.getCidade());
		wr.remover(weather);
	}
	
	public void deletarDaCidade(String cidade) {
		wr.removerDaCidade(cidade);
	}
	

	public boolean buscarPorCidadeHora(String cidadeHora) {
		List<?> a = wr.buscarPorPK(cidadeHora);
		if(a.isEmpty())
			return false;
		else
			return true;
	}
	
}
