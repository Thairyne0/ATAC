package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.example.Entity.Tratta;


public class TrattoDAO {
    private EntityManager em;

    public TrattoDAO (EntityManager em) {this.em = em;}

    public void save (Tratta tratta) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(tratta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
