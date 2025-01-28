package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Entity.Mezzi;


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
}
