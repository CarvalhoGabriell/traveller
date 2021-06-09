package org.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.traveller.model.Avaliacao;
import org.traveller.model.Usuario;
import org.traveller.utils.JPAUtil;


public class AvaliarDAO {
	
	
	public void save(Avaliacao aval) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aval);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Avaliacao> showAll() {
		
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT a FROM Avaliacao c";
		TypedQuery<Avaliacao> query = manager.createQuery(jpql, Avaliacao.class);
		return query.getResultList();
	}
	
	public List<Avaliacao> showOneComent(Usuario user) {
		
		EntityManager manager= JPAUtil.getEntityManager();

		String strSQL = "select s from Avaliacao s where id_login_user = :id";
		TypedQuery<Avaliacao> query = manager.createQuery(strSQL, Avaliacao.class);
		System.out.println(user.getIdUsuario());
		query.setParameter("id", user.getIdUsuario());
		return query.getResultList();
	}
}
