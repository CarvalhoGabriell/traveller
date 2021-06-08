package org.traveller.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.traveller.model.Empresa;
import org.traveller.model.Usuario;
import org.traveller.utils.JPAUtil;

public class EmpresaDao {

	
	
	public void save (Empresa empresa) {
	EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(empresa);
		manager.getTransaction().commit();
		manager.close();
	}
	
		public List<Empresa> getAll(){
			EntityManager manager = JPAUtil.getEntityManager();
			String jpql = "SELECT e FROM Empresa e";
			TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
			return query.getResultList();
		}
	}


