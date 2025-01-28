package org.example.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import jakarta.persistence.TypedQuery;
import org.example.Entity.Rivenditore;

import java.util.List;

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

	public List<Rivenditore> getAllRivenditori() {
		TypedQuery<Rivenditore> query = em.createQuery("SELECT r FROM Rivenditore r", Rivenditore.class);
		return query.getResultList();
	}

	public Rivenditore getRivenditoreById(Long id) {
		return em.find(Rivenditore.class, id);
	}
}
