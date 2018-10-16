package br.com.cast.weatherapi.repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.weatherapi.entidade.Weather;

@Repository
public class WeatherRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Weather> buscarPorPK(String pk) {
		Query query = em.createQuery("from " + Weather.class.getName() + " where cidadehora = :pk");
		query.setParameter("pk", pk);
		return query.getResultList();
	}
	
	public List<Weather> buscarCincoDaCidade(String cidade) {

		Query query = em.createQuery("from " + Weather.class.getName() + " where cidade = :cidade");
		query.setParameter("cidade", cidade);
		query.setMaxResults(5);
		return query.getResultList();
//		em.setProperty("data", data);
//		return 
		
	}
	
	@Transactional
	public void inserir(Weather weather) {
		em.merge(weather);
	}
	
	@Transactional
	public void remover(Weather weather) {
		em.remove(weather);
	}
	
	@Transactional
	public void removerDaCidadeHora(String cidadeHora) {
		em.remove(buscarPorPK(cidadeHora));
	}
	@Transactional
	public void removerDaCidade(String cidade) {
		Query query = em.createQuery("delete from " + Weather.class.getName() + " Where cidade = :cidade");
		query.setParameter("cidade", cidade);
		query.executeUpdate();
	}
}
