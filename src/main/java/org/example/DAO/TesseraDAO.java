package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.Entity.Tessera;

import java.util.List;

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

	public Tessera getTesseraPerNomeECognome(String nome, String cognome) {
		TypedQuery<Tessera> query = em.createQuery(
			"SELECT t FROM Tessera t WHERE t.utente.nome = :nome AND t.utente.cognome = :cognome",
			Tessera.class
		);
		query.setParameter("nome", nome);
		query.setParameter("cognome", cognome);

		// Otteniamo la lista di risultati (che potrebbe essere vuota)
		List<Tessera> results = query.getResultList();

		// Se la lista non è vuota, restituiamo il primo elemento, altrimenti null
		if (!results.isEmpty()) {
			return results.get(0);
		}

		return null;  // Nessun risultato trovato
	}

}
