package org.traveller.insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.traveller.dao.EmpresaDao;
import org.traveller.model.Empresa;

public class InsertEmpresa {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Reunidas","facebook.com","Empresa de venda de carros");
		
		EmpresaDao dao = new EmpresaDao();
		dao.save(empresa);
		
		/*EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("traveller-persistence");
		EntityManager em = fabrica.createEntityManager();
		
		em.persist(empresa);
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();*/
	}

}
