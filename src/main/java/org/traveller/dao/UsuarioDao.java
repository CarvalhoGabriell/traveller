package org.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.traveller.model.Usuario;
import org.traveller.utils.JPAUtil;

public class UsuarioDao {
	
	public void save(Usuario usuario) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Usuario> getAll(){
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT s FROM Usuario s";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}
	
	public void update(Usuario usuario){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.flush();
		manager.getTransaction().commit();
		
		manager.close();
	}
	

}
