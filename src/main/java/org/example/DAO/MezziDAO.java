package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.Entity.DistributoreAutomatico;
import org.example.Entity.Mezzi;

import java.util.List;


public class MezziDAO {
    private EntityManager em;

    public MezziDAO (EntityManager em) {this.em = em;}

    public void save (Mezzi mezzi) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(mezzi);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Mezzi> getAllMezzi() {
        TypedQuery<Mezzi> query = em.createQuery("SELECT m FROM Mezzi m", Mezzi.class);
        return query.getResultList();
    }
}
