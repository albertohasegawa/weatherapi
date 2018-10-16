package br.com.cast.weatherapi.dto;

public class ResultWeatherDTO {

	private Double temp_min;
	private Double temp_max;
	private Double pressao;
	private Integer umidade;
	private String data;
	private String descricao_main;
	private String icone;
	private Double velocidade_vento;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao_main() {
		return descricao_main;
	}
	public void setDescricao_main(String descricao_main) {
		this.descricao_main = descricao_main;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	public Double getVelocidade_vento() {
		return velocidade_vento;
	}
	public void setVelocidade_vento(Double velocidade_vento) {
		this.velocidade_vento = velocidade_vento;
	}
	
	
	
	
	
}
