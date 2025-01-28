package org.example.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.example.Entity.Rivenditore;

public class RivenditoreDAO {

	private EntityManager em;

	public RivenditoreDAO (EntityManager em) {
		this.em = em;
	}

	public void save (Rivenditore rivenditore) {
		EntityTransaction transition = em.getTransaction();
		try {
			transition.begin();
			em.persist(rivenditore);
			transition.commit();
		} catch (Exception e) {
			if (transition.isActive()) {
				transition.rollback();
			}
			e.printStackTrace();
		}

	}
}
