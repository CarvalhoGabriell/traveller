package org.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.traveller.model.Carro;
import org.traveller.utils.JPAUtil;

public class CarroDAO {
	
	
	public void save(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(carro);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Carro> getAllCarros(){
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT c FROM Carro c";
		TypedQuery<Carro> query = manager.createQuery(jpql, Carro.class);
		return query.getResultList();
	}
	
	public void update(Carro carro){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(carro);
		manager.flush();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Carro findBy(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		return manager.find(Carro.class, id);
	}
	
	public void delete(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		Carro carro = manager.find(Carro.class, id);
		manager.getTransaction().begin();
		
		carro = manager.merge(carro);
		manager.remove(carro);
		manager.flush();
		System.out.println("Carro deletado");
		manager.getTransaction().commit();
		manager.close();
	}


}
