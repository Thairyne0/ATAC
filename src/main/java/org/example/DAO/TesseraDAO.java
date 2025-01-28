package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Entity.Tessera;

public class TesseraDAO {

	private EntityManager em;

	public TesseraDAO (EntityManager em) {
		this.em = em;
	}

	public void save (Tessera tessera) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(tessera);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
