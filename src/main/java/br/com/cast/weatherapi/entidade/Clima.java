package br.com.cast.weatherapi.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Clima {

	@Id
	private Integer dt;
	
}
