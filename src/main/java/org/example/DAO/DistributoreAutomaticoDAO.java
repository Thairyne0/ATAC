package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Entity.DistributoreAutomatico;


public class DistributoreAutomaticoDAO {
	private EntityManager em;

	public DistributoreAutomaticoDAO (EntityManager em) {
		this.em = em;
	}

	public void save (DistributoreAutomatico dist) {
		EntityTransaction transition = em.getTransaction();
		try {
			transition.begin();
			em.persist(dist);
			transition.commit();
		} catch (Exception e) {
			if (transition.isActive()) {
				transition.rollback();
			}
			e.printStackTrace();
		}

	}
}
