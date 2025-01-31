package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import jakarta.persistence.TypedQuery;
import org.example.Entity.Tratta;
import org.example.Entity.Tratta;

import java.util.List;


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

    public List<Tratta> getAllTratta() {
        TypedQuery<Tratta> query = em.createQuery("SELECT t FROM Tratta t", Tratta.class);
        return query.getResultList();
    }

    public Tratta findById(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Tratta tratta = em.find(Tratta.class, id);
            if (tratta != null) {
                System.out.println("Tratta trovata: " + tratta);
                transaction.commit();
                return tratta;

            } else {
                System.out.println("Tratta con id: " + id + "non trovata");

            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
//            em.close();
        }
        return null;
    }



}
