package org.traveller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public Usuario findById(int id) {
		EntityManager manager= JPAUtil.getEntityManager();
		return manager.find(Usuario.class, id);
	}
	
	public void delete(int id) {
		EntityManager manager= JPAUtil.getEntityManager();
		Usuario user = manager.find(Usuario.class, id);
		manager.getTransaction().begin();
		user = manager.merge(user);
		manager.remove(user);
		manager.flush();
		System.out.println("Deletando Usuario ID "+user.getIdUsuario());
		
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Usuario exist(Usuario usuario) {
		Usuario verifica = new Usuario();
		EntityManager manager = JPAUtil.getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE "
									+ "u.email = :email AND "
									+ "u.senha = :senha", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		
		try {
			verifica = query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		return verifica;
	}

}
