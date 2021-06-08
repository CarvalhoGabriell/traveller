package org.traveller.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String TRAVELLER_PERSISTENCE = "traveller-persistence";
	
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(TRAVELLER_PERSISTENCE);
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
}
